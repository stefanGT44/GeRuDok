package DataView;

import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.Document;
import Workspace.Project;
/**
 * 
 * Predstavlja prozor u multidokumentalnom inerfejsu, kao i <code>Observer</code> za <code>Project</code> koji je u isto vreme model.
 * Kreiranje dokumenta se takodje radi u projektu, pa se notifikuju observeri, to jest ova klasa, gde se prosledjuju novokreirani
 * dokument i onda se u update metodi ove klase pravi njegov viewer.
 * 
 * 
 * @see Workspace.Project
 * @see Workspace.Document
 * @see DataView.DocumentView
 * @see Workspace.Workspace
 * @see DataView.WorkspaceView
 * 
 * @author Anagnosti
 *
 */
public class ProjectView extends JInternalFrame implements Observer{
	
	public static final int xOffset = 30;
	public static final int yOffset = 30;
	public static int openFrameCount = 0;
	private Project project;
	private ArrayList<DocumentView> documentViews = new ArrayList<>();

	private JTabbedPane framework = new JTabbedPane();

	public ProjectView(Project project) {
		super("", true, true, true, true);
		this.project = project;
		project.addObserver(this);

		++openFrameCount;
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		setIconifiable(true);
		setClosable(true);

		this.setFrameIcon(null);

		setSize(400, 400);
		this.add(framework);
		setVisible(true);
		setRequestFocusEnabled(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		View.get().getWorkspaceView().add(this);
		View.get().getWorkspaceView().getProjectViews().add(this);
		update(project, null);
	}

	public void addTab(DocumentView documentView) {
		framework.addTab(documentView.getDocument().getName(), documentView);
		documentViews.add(documentView);
	}

	public void renameTab(int index, String str) {
		framework.setTitleAt(index, str);
	}

	public void focusTab(int index) {
		framework.setSelectedIndex(index);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if(arg1 != null)
		if(arg1.equals("delete"))
		{
			View.get().getWorkspaceView().getProjectViews().remove(this);
			try {
				this.setClosed(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (arg1 instanceof Document && !((Document) arg1).getName().contains("- (shared)")) {
			DocumentView documentView = new DocumentView((Document) arg1);
			documentView.setName(((Document) arg1).getName());
			addTab(documentView);
			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
			try {
				View.get().getModel().getWorkspaceTree()
						.expandRow(View.get().getModel().getWorkspaceTree().getSelectionRows()[0]);
			} catch (Exception e) {
			}
		}

		if (arg1 instanceof Integer) {
			focusTab((Integer) arg1);
		} else {
			if (arg1 instanceof Boolean) {
				try {
					this.setSelected((Boolean) arg1);
					this.setVisible((Boolean) arg1);
					this.toFront();
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		}

		this.setTitle(project.getName());

		if (arg1 instanceof DocumentView) {
			addTab((DocumentView) arg1);
		}

		if (arg1 instanceof Document && ((Document) arg1).getName().contains("- (shared)")) {
			DocumentView documentView = new DocumentView((Document)arg1);
			documentView.setCopy(true);
			addTab(documentView);
			documentView.update(null,"share");
			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
		}

		for (int i = 0; i < documentViews.size(); i++) {
			renameTab(i, documentViews.get(i).getDocument().getName());
		}
		if (arg1 instanceof Document){
		for (ProjectView pv: View.get().getWorkspaceView().getProjectViews()){
			for (DocumentView dv: pv.getDocumentViews()){
				if (dv.getDocument()==(Document)arg1){
					pv.update(null, null);
				}
			}
		}
		}
		
		
	}

	public ArrayList<DocumentView> getDocumentViews() {
		return documentViews;
	}

	public JTabbedPane getFramework() {
		return framework;
	}

	
}