package Actions;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

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
 * Klasa koja sluzi za importovanje dokumenta na datu lokaciju. Pokrece browse i preko istog se navigira do lokacije.
 * Metodom <code>Import</code> se preuzima serijalizovan dokument sa date lokacije koja je izabrana preko browse-a.
 * 
 * 
 * @see Actions.BrowseAction
 * @see Workspace.Document
 * 
 * 
 * @author Anagnosti
 *
 */
public class ImportDocAction extends AbstractActionManager {

	public ImportDocAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/import.png"));

		putValue(NAME, "Import Document");
		putValue(SHORT_DESCRIPTION, "Import Document Action");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		View.get().getActionManager().getBrowseAction().setAction("importDoc");
		View.get().getActionManager().getBrowseAction().actionPerformed(null);

	}

	public void importuj(String location) {
		String[] str = location.split("\\.");

		if (!str[str.length - 1].equals("gdoc")) {
			System.out.println("ERROR: false file extention. Choose \"gdoc\" extention! ");
			return;
		}

		File f = new File(location);

		try {
			ObjectInputStream ios1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			Document document = (Document) ios1.readObject();

			Project project = (Project) View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
			project.getDocuments().add(document);
			project.importDocument(document);

			for (Page p : document.getPages()) {
				document.importPage(p);
				for (Slot s : p.getSlots()) {
					p.importSlot(s);
					for (Element e : s.getElements()) {
						s.importElement((MainElement) e);
					}
				}
			}

			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
		} catch (

		FileNotFoundException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (

		Exception e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("documetn imported");
	}

}
