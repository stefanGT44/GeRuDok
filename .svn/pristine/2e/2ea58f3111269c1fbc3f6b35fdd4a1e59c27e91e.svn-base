package Actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import GUI_Elements.ElementPopupChooser;
import MVC.View;
import Workspace.DataType;
import Workspace.Slot;
/**
 * Klasa za kreiranje novog elementa.
 * 
 * @see DataView.ElementView
 * @see Actions.NewObjectAction
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class NewElementAction extends AbstractActionManager {

	public NewElementAction() {
		putValue(SMALL_ICON, loadIcon("images/addIcon.png"));
		putValue(NAME, "New Element");
		putValue(SHORT_DESCRIPTION, "New Element");
	}
/**
 * 
 * Poziva se add metoda iz interfejsa <code>DataType</code>.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object p = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof DataType){
			((DataType) p).add();
		}
		
		if(p instanceof Slot)
		View.get().getElementPopup().setSlot((Slot)p);
		View.get().getElementPopup().setVisible(true);

	}

}
