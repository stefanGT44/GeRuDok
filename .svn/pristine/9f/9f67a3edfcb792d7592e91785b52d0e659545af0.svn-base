package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import com.sun.glass.events.KeyEvent;

import MVC.View;
import Workspace.DataType;
import Workspace.Document;
import Workspace.Project;


/**
 * 
 * Klasa za kreiranje novog dokumenta.
 * 
 * 
 * @see DataView.DocumentView
 * @see Actions.NewObjectAction
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class NewDocumentAction extends AbstractActionManager {

	public NewDocumentAction() {

		putValue(SMALL_ICON, loadIcon("images/addDocumentIcon.png"));
		putValue(NAME, "New Document");
		putValue(SHORT_DESCRIPTION, "New Document");
	}

/**
 * 
 * Poziva se add metoda iz interfejsa <code>DataType</code>.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object p = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof DataType){
			((DataType) p).add();
		}

	}

}
