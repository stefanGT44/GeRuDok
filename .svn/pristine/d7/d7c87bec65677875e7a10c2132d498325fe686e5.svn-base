package Actions;

import java.awt.event.ActionEvent;

import MVC.View;

/**
 * 
 * U klasi <code>CommandManager</code> poziva <code>Redo</code> akciju. Akcijom <code>Redo</code> se izvrsava "akcija"
 *  vracanja za jedan korak unazad.
 * 
 * @author Anagnosti
 *
 */
public class Redo extends AbstractActionManager {

	public Redo() {

		putValue(SMALL_ICON, loadIcon("images/redo.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo action");
		
		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		View.get().getGraphicEditor().getEv().getMainElement().getCommandManager().doCommand();

	}

}
