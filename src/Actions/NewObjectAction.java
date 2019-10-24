package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import com.sun.glass.events.KeyEvent;

import DataView.ProjectView;
import DataView.SlotView;
import MVC.View;
import Workspace.DataType;
import Workspace.Document;
import Workspace.Page;
import Workspace.Project;
import Workspace.Slot;
import Workspace.Workspace;


/**
 * 
 * Klasa sluzi za pravljenje novih objekata.
 * 
 * @see Workspace.DataType
 * @see Actions.NewProjectAction
 * @see Actions.NewDocumentAction
 * @see Actions.NewPageAction
 * @see Actions.NewSlotAction
 * @see Actions.NewElementAction 
 *  
 * @author Anagnosti
 *
 */
public class NewObjectAction extends AbstractActionManager {

	public static int projectCount, documentCount, pageCount, slotCount, elementCount;
	
	public NewObjectAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/addIcon.png"));
		
		putValue(NAME, "New Object");
		putValue(SHORT_DESCRIPTION, "New Object");
		
	}
/**
 * 
 * U zavisnosti od tipa, automatski ce se pozvati metoda add od odredjenog objekta. U slucaju pokretanja programa, nista nije
 * selektovano, te if statement <code>p==null</code> sluzi za kreiranje projekta na prvo pozivanje akcije.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object p = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof DataType){
			((DataType) p).add();
		}
		
		if(p == null)
		{
			View.get().getModel().getWorkspaceModel().getWorkspace().add();
		}
	}
					
}



