package Actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import MVC.View;
import Workspace.Slot;


/**
 * 
 * U odnosu na to gde se kursor trenutno nalazi, ikonica preko koje se nalazi ce biti obojena, to jest "highlight"-ovana. 
 *  
 * 
 * @see DataView.ElementPopupChooser
 *  
 * @author Anagnosti
 *
 */
public class HoverAction implements MouseListener {

/**
 * 
 * Metoda <code>mouseClicked</code> prati gde se nalazi kursor. U situaciji kada kursor predje ili "hover"-uje (pojavi se)
 * preko slike za odabir tipa elementa, ikonica preko koje se trenutno kursor nalazi ce postati "highlight"-ovana, odnosno obojena.
 * 
 * 	
 */
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() instanceof JLabel) {
			if (((JLabel) e.getSource()).getIcon() == View.get().getElementPopup().getImageICO()) {
				Slot slot = View.get().getElementPopup().getSlot();
				slot.addElement("image");
				View.get().getElementPopup().setVisible(false);
			} else if (((JLabel) e.getSource()).getIcon() == View.get().getElementPopup().getTextICO()) {
				Slot slot = View.get().getElementPopup().getSlot();
				slot.addElement("text");
				View.get().getElementPopup().setVisible(false);
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		View.get().getElementPopup().changePic((JLabel) e.getSource());

	}

	@Override
	public void mouseExited(MouseEvent e) {
		View.get().getElementPopup().changePic((JLabel) e.getSource());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
