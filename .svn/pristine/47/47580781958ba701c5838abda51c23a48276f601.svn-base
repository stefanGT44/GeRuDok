package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

/**
 * 
 * Sluzi da bi se izaslo iz GeRuDok apllikacije.
 * 
 * @author Anagnosti
 *
 */
public class ExitAction extends AbstractActionManager {

	public ExitAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/exit.png"));
		putValue(NAME, "Exit");
		putValue(SHORT_DESCRIPTION, "Exit Application");
	}

/**
 * 
 * Akcijom se izlazi iz pokrenute aplikacije.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);

	}

}