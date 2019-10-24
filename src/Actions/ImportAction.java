package Actions;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import com.sun.glass.events.KeyEvent;
import MVC.View;
import Workspace.Document;
import Workspace.Element;
import Workspace.MainElement;
import Workspace.Page;
import Workspace.Project;
import Workspace.Slot;
/**
 * 
 * Klasa koja sluzi za importovanje projekta na datu lokaciju. Pokrece browse i preko istog se navigira do lokacije.
 * Metodom <code>Import</code> se preuzima serijalizovan projekat sa date lokacije koja je izabrana preko browse-a.
 * 
 * 
 * @see Actions.BrowseAction
 * @see Workspace.Project
 * 
 * @author Anagnosti
 *
 */
public class ImportAction extends AbstractActionManager {

	public ImportAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/import.png"));

		putValue(NAME, "Import Project");
		putValue(SHORT_DESCRIPTION, "Import Project");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		View.get().getActionManager().getBrowseAction().setAction("import");
		View.get().getActionManager().getBrowseAction().actionPerformed(null);

	}

	public void importuj(String location) {
		String[] str = location.split("\\.");

		if (!str[str.length - 1].equals("gpr")) {
			System.out.println("ERROR: false file extention. Choose \"gpr\" extention! ");
			return;
		}

		File f = new File(location);

		try {
			ObjectInputStream ios1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			Project project = (Project) ios1.readObject();

			View.get().getModel().getWorkspaceModel().getWorkspace().addProject(project);
			View.get().getModel().getWorkspaceModel().getWorkspace().importProject(project);

			for (Document d : project.getDocuments()) {
				project.importDocument(d);
				for (Page p : d.getPages()) {
					d.importPage(p);
					for (Slot s : p.getSlots()) {
						p.importSlot(s);
						for (Element e : s.getElements()) {
							s.importElement((MainElement) e);
						}
					}
				}
			}
			
			

			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
