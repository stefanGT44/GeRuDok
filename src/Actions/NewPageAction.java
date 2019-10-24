package Actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.DataType;
import Workspace.Document;
import Workspace.Page;


/**
 * 
 * Klasa za kreiranje novog page-a, to jest novu stranicu.
 * 
 * @see DataView.PageView
 * @see Actions.NewObjectAction
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class NewPageAction extends AbstractActionManager{

	public NewPageAction() {
		
		putValue(SMALL_ICON, loadIcon("images/addPageIcon.png"));
		putValue(NAME, "New Page");
		putValue(SHORT_DESCRIPTION, "New Page");
	}
/**
 * 
 * Poziva se add metoda iz interfejsa <code>DataType</code>.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object p = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof DataType){
			((DataType) p).add();
		}
		
	}

}
