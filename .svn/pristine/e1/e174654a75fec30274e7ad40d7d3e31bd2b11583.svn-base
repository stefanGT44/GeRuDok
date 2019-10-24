package DataView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.Document;
import Workspace.Page;
import Workspace.Project;
/**
 * 
 * 
 * Predstavlja vizuelni prikaz dokumenta u centralnom View-u, to jest u <code>WorkspaceView</code> kao tab unutar 
 * <code>ProjectView</code> prozora. <code>DocumentView</code> predstavlja <code>Observer</code> za model dokumenta
 * koji mu se dodaje. Moze da se klonira radi share-ovanja medju vise projekata. Povezan je sa svojim Observable komponentama. 
 * 
 * 
 * @see DataView.PageView
 * @see Dataview.ProjectView
 * @see Workspace.Document
 * @author Anagnosti
 *
 */
public class DocumentView extends JPanel implements Observer, Cloneable{


	public static int count = 0;

	private String name;
	private JScrollPane scrollPane;
	private JPanel panel;
	private Document document;
	private boolean copy;
	private ArrayList<PageView> pageViews = new ArrayList<>();

	public DocumentView(Document document) {
		this.document = document;
		document.addObserver(this);
		panel = new JPanel();
		BoxLayout b1 = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(b1);
		scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public DocumentView Clone(){
		try {
			return (DocumentView)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addPage(PageView pageView) {
		panel.add(pageView);
		panel.add(Box.createVerticalStrut(10));
		revalidate();
		repaint();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
		if (!pageViews.contains(pageView))
			pageViews.add(pageView);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(arg1 != null){
			if(arg1.equals("delete"))
			{
				for(ProjectView pv : View.get().getWorkspaceView().getProjectViews())
				{
					
					if(pv.getDocumentViews().contains(this))
					{
						pv.getFramework().removeTabAt(pv.getDocumentViews().indexOf(this));
						pv.getDocumentViews().remove(this);
					}
				}
				
				return;
			}
		

		}
		if (arg1 instanceof String){
			for (Page page:document.getPages()){
				PageView pv = new PageView(page);
				addPage(pv);
				pv.update(null, "share");
			}
		}
		if (arg1 instanceof Page){
			PageView pageView = new PageView((Page)arg1);
			pageView.setName(((Page)arg1).getName());
			addPage(pageView);
			try {
				View.get().getModel().getWorkspaceTree()
						.expandRow(View.get().getModel().getWorkspaceTree().getSelectionRows()[0]);
			} catch (Exception e) {
			}
		}
		if (arg1 instanceof PageView) {
			if (!pageViews.contains((PageView) arg1)) {
				addPage((PageView) arg1);
			} else {
				panel.removeAll();
				pageViews.remove((PageView) arg1);
				for (PageView p : pageViews) {
					addPage(p);
				}
			}

		}
	}

	public ArrayList<PageView> getPageViews() {
		return pageViews;
	}

	public void setPageViews(ArrayList<PageView> pageViews) {
		this.pageViews = pageViews;
	}

	public boolean isCopy() {
		return copy;
	}

	public void setCopy(boolean copy) {
		this.copy = copy;
	}

	public JPanel getPanel() {
		return panel;
	}
	
	
}