package MVC;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import Workspace.Project;
import Workspace.Workspace;
/**
 * 
 * Model stabla.
 * 
 * @see javax.swing.tree.DefaultTreeModel
 * 
 * @author Anagnosti
 *
 */
public class WorkspaceModel extends DefaultTreeModel{
	
	public static Workspace workspace = new Workspace();
	
	public WorkspaceModel() {
		super((TreeNode) workspace);
		
	}

	public void addProject(Project project) {
		((Workspace)getRoot()).addProject(project);
	}
	
	public Workspace getWorkspace() {
		return workspace;
	}
	
}
