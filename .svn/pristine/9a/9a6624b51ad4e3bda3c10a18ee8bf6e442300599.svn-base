package Actions;

import java.awt.event.ActionEvent;

import DataView.ElementView;
import MVC.View;
/**
 * 
 *
 * Akcija za postavljanje <code>currentState</code> u <code>StateManager</code> u state, to jest stanje <code>Select</code>
 * 
 * @author Anagnosti
 *
 */
public class Select extends AbstractActionManager {

	public Select() {
		putValue(SMALL_ICON, loadIcon("images/select.png"));
		putValue(NAME, "Select");
		putValue(SHORT_DESCRIPTION, "Select action");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ElementView ev = View.get().getGraphicEditor().getEv();
		ev.getMainElement().startSelectState();

	}

}
