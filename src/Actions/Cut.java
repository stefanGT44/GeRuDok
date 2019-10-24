package Actions;

import java.awt.event.ActionEvent;
import MVC.View;
/**
 * 
 * Klasa <code>Cut</code> primenjuje <code>actionPerformed</code> za <code>Copy</code> i <code>DeleteShapeAction</code>.
 * Time su objekti spremni da budu Paste-ovani na novu poziciju i da se izbrisu sa stare pozicije.
 * 
 * 
 * @see Actions.Copy
 * @see Actions.DeleteShapeAction
 * 
 * @author Anagnosti
 *
 */
public class Cut extends AbstractActionManager{
	
	public Cut() {
		putValue(SMALL_ICON, loadIcon("images/cut.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut action");
	}

	
/**
 * 
 * Pozivaju se <code>actionPerformed</code> metode za Klase <code>Copy</code> i <code>DeleteShapeAction</code>
 * 
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {		
		View.get().getActionManager().getCopy().actionPerformed(e);
		View.get().getActionManager().getDeleteShapeAction().actionPerformed(e);
	}
	

}
