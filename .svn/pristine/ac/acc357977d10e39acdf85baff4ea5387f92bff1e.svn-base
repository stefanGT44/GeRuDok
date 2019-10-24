package Actions;

import java.awt.event.ActionEvent;

import DataView.ElementView;
import MVC.View;

/**
 * 
 * Akcija za postavljanje <code>currentState</code> u <code>StateManager</code> u state, to jest stanje <code>Rectangle</code>
 * 
 * @author Anagnosti
 *
 */
public class RectangleAction extends AbstractActionManager {

	public RectangleAction() {
		putValue(SMALL_ICON, loadIcon("images/RectangleAction.png"));
		putValue(NAME, "Rectangle");
		putValue(SHORT_DESCRIPTION, "Create rectangle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ElementView ev = View.get().getGraphicEditor().getEv();
		ev.getMainElement().startRectangleState();
	}
}
