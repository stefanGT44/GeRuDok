package MVC;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

import Actions.PopupMenuAction;
import TreeConfig.WorkspaceTreeCellRendered;
import TreeConfig.WorkspaceTreeController;
import TreeConfig.WorkspaceTreeEditor;
import Workspace.Project;
/**
 * 
 * View stabla
 * 
 * @see javax.swing.JTree
 * 
 * @author Anagnosti
 *
 */
public class WorkspaceTree extends JTree{

	   public WorkspaceTree() {
	      addTreeSelectionListener(new WorkspaceTreeController());
	      setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
	      setCellRenderer(new WorkspaceTreeCellRendered());
	      setEditable(true);
	      
	      
	      addMouseListener(new PopupMenuAction());
	   }
	   
	   
	   public void addProject(Project project) {
		   ((WorkspaceModel)getModel()).addProject(project);
			SwingUtilities.updateComponentTreeUI(this);
	   }
	
}
