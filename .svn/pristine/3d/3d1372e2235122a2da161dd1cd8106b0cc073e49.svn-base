package Actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.DataType;
import Workspace.Project;

public class DeleteAction extends AbstractActionManager {

	public DeleteAction() {

		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete Action");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object p = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof Project) {
			if (!((Project) p).getDocuments().isEmpty()){
				View.get().getDeleteProjectPopup().setVisible(true);
				SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
				return;
			}
			((Project) p).delete();
			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
			return;
		}
		if (p instanceof DataType) {
			((DataType) p).delete();
		}

		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

}
