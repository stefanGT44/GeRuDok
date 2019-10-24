package Actions;

import java.awt.event.ActionEvent;

import DataView.ElementView;
import MVC.View;
/**
 * 
 * Klasa <code>Paste</code> podesava <code>State</code> u <code>MainElement</code> na <code>Paste</code>.
 * 
 * 
 * @see StateActions.PasteState
 * @see Workspace.MainElement
 * 
 * @author Anagnosti
 *
 */
public class Paste extends AbstractActionManager {

	public Paste() {
		putValue(SMALL_ICON, loadIcon("images/paste.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste action");
	}
/**
 * 
 * Setuje trenutno stanje (current state) u <code>MainElement</code> da bude <code>Paste</code>. Svaki put pri izvrsavanju
 * akcije se izvrsava akcija <code>Paste</code>.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ElementView ev = View.get().getGraphicEditor().getEv();
		ev.getMainElement().startPasteState();

	}

}
