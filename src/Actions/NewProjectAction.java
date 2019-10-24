package Actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import DataView.ProjectView;
import MVC.View;
import Workspace.DataType;
import Workspace.Document;
import Workspace.Project;
import Workspace.Workspace;
/**
 * 
 * Klasa za kreiranje novog projekta.
 * 
 * @see DataView.Project
 * @see Actions.NewObjectAction
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class NewProjectAction extends AbstractActionManager{

	public NewProjectAction() {
		
		putValue(SMALL_ICON, loadIcon("images/addProjectIcon.png"));
		putValue(NAME, "New Project");
		putValue(SHORT_DESCRIPTION, "New Project");
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
		
		if(p == null)
		{
			View.get().getModel().getWorkspaceModel().getWorkspace().add();
		}
		
	}

}
