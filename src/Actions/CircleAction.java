package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import DataView.DocumentView;
import DataView.ElementView;
import DataView.PageView;
import DataView.ProjectView;
import DataView.SlotView;
import DataView.WorkspaceView;
import MVC.View;
/**
 * 
 * Klasa <code>CircleAction</code> radi sledece: Trenutni State, to jest stanje u klasi StateManager se postavlja kao Circle State.
 * 
 * 
 * @see StateActions.StateManager
 * 
 * @author Anagnosti
 *
 */
public class CircleAction extends AbstractActionManager {

	public CircleAction() {

		putValue(SMALL_ICON, loadIcon("images/CircleAction.png"));
		putValue(NAME, "Circle");
		putValue(SHORT_DESCRIPTION, "Create circle");
	}

	@Override
	
/**
 * 
 * Postavlja se stanje u klasi StateManager kao Circle.
 * 
 */
	public void actionPerformed(ActionEvent arg0) {
		ElementView ev = View.get().getGraphicEditor().getEv();
		ev.getMainElement().startCircleState();

	}

}