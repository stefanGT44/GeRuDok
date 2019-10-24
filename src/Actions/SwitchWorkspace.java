package Actions;

import java.awt.event.ActionEvent;

import MVC.View;
/**
 * 
 * Prikaze se PopUp Window "Choose Workspace" i resetuje mu se tekst u JTextField-u. 
 * 
 * @see GUI_Elements.ChooseWorkspace
 * 
 * 
 * @author Anagnosti
 *
 */
public class SwitchWorkspace extends AbstractActionManager{
	
	public SwitchWorkspace(){
		//putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
	      //  KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	//putValue(SMALL_ICON, loadIcon("images/bold1.png"));
	
	putValue(NAME, "Switch Workspace");
	putValue(SHORT_DESCRIPTION, "Changes the active workspace");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		View.get().getChooseWorkspace().getTf().setText("");
		View.get().getChooseWorkspace().setVisible(true);
	}

}
