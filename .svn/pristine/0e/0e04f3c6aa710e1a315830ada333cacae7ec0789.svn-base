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
import Workspace.Project;

/**
 * 
 * 
 * Pretstavlja akciju koja ukoliko <code>Project</code> ima lokaciju na kojoj treba da se nalazi, sacuva ranije pomenut
 * <code>Project</code> u lokalnoj memoriji. Postoji takodje predefinisana lokacija.
 * 
 * 
 * @author Anagnosti
 *
 */
public class Save extends AbstractActionManager {

	
	public Save()
	{

		putValue(SMALL_ICON, loadIcon("images/export.png"));

		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save changes");
		setEnabled(false);
	}
/**
 * 
 * Cuvaju se projekti i svi podaci koje projekat sadrzi. Za cuvanje podataka se koristi <code>ObjectOutputStream</code>
 * s obzirom da je u pitanju baratanje, to je upis kompleksnijih objekata u datoteku. Pozivom metode <code>writeObject()</code>
 * se serijalizuje objekat u niz bajtova i salje u tok.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
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

		Project project = (Project) View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();

		File f = new File(project.getLocation() + "\\" + project.getName() + ".gpr");

		ObjectOutputStream oos1 = null;
		try {
			oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			oos1.writeObject(project);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				oos1.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

}
