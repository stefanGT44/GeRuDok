package Actions;

import java.awt.event.ActionEvent;

import MVC.View;
/**
 *
 *
 * Setuje se u <code>CommandManager</code> da currentCommand bude "Undo" command.
 * 
 * @see commands.CommandManager
 *
 * 
 * @author Anagnosti
 *
 */
public class Undo extends AbstractActionManager {

	public Undo() {

		putValue(SMALL_ICON, loadIcon("images/undo.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo action");
		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		View.get().getGraphicEditor().getEv().getMainElement().getCommandManager().undoCommand();
	}

	
}
