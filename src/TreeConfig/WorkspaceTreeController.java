package TreeConfig;

import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import Workspace.Document;
import Workspace.Project;

/**
 * 
 * Kada se klikne na project ili dokument na drvetu, fokusiraju se odgovarajuci view-eri na glavnom prozoru.
 * 
 * 
 * 
 * @see Workspace.Project
 * @see Workspace.Document
 * @see MVC.WorkspaceTree
 * 
 * @author Anagnosti
 *
 */
public class WorkspaceTreeController implements TreeSelectionListener{
	
	public void valueChanged(TreeSelectionEvent e) {
		
		TreePath path = e.getPath();
		for(int i=0; i<path.getPathCount(); i++){

			if(path.getPathComponent(i) instanceof Document)
			{
				Document d =(Document)path.getPathComponent(i);
				Project parent = (((Project)(d.getParent())));
				parent.focusTab(parent.getIndex(d));
				break;
			}
			
			if(path.getPathComponent(i) instanceof Project){
				Project p =(Project)path.getPathComponent(i);
				p.isFocused(true);
				
			}
		}
	}
	
	

}
