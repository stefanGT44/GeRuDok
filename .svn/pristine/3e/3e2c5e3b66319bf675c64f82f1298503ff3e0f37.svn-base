package Actions;

import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import DataView.DocumentView;
import DataView.ElementView;
import DataView.PageView;
import DataView.ProjectView;
import DataView.SlotView;
import MVC.View;
import MVC.WorkspaceModel;
import Workspace.Project;
import Workspace.Workspace;


/**
 * 
 * Akcija koja ce prvo da izbaci browse window za trazenje mesta u lokalnoj memoriji gde zelimo sacuvati projekat i 
 * uredno se projektu dodeljuje na taj nacin lokacija kako bi kasnije bilo moguce samo pozvati klasu <code>Save</code> i 
 * automatski se projekat sacuva na toj lokaciji. Na taj nacin se menja trenutna lokacija u memoriji u slucaju da se nova
 * lokacija ne podudara sa prethodno zapamcenom.
 * 
 * 
 * @return String
 * @author Anagnosti
 *
 */
public class SaveAs extends AbstractActionManager {

	public SaveAs() {
		putValue(SMALL_ICON, loadIcon("images/export.png"));

		putValue(NAME, "SaveAs");
		putValue(SHORT_DESCRIPTION, "Save to location");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.get().getActionManager().getBrowseAction().setAction("saveAs");
		View.get().getActionManager().getBrowseAction().actionPerformed(null);

	}

	public void save(String location) {
		
		for (ProjectView projectView : View.get().getWorkspaceView().getProjectViews()) {
			projectView.getProject().setSize(projectView.getSize());
			projectView.getProject().setPosition(projectView.getLocation());
			for (DocumentView documentView : projectView.getDocumentViews()) {
				for (PageView pageView : documentView.getPageViews()) {
					for (SlotView slotView : pageView.getSlotViews()) {
						slotView.getSlot().setSize(slotView.getSize());
						slotView.getSlot().setLocation(slotView.getLocation());
						for (ElementView elementView : slotView.getElementViews()) {
							elementView.getMainElement().setSize(elementView.getSize());
							elementView.getMainElement().setLocation(elementView.getLocation());
						}
					}
				}
			}
		}
		
		Project project = (Project)View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();	
		project.setLocation(location);
		
		File f = new File(location+"\\" + project.getName() + ".gpr");
		
		ObjectOutputStream oos1 = null;
		try {
			oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			oos1.writeObject(project);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally{
			try {
				oos1.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
	}

}
