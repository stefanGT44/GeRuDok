package TreeConfig;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import MVC.View;
import Workspace.Document;
import Workspace.Element;
import Workspace.Page;
import Workspace.Project;
import Workspace.Slot;

/**
 * 
 * Klasa je zaduzena za rename-ovanje modela u drvetu kad se trput klikne na objekat, moze se rename-ovati.
 * 
 * 
 * @see Workspace.Project
 * @see Workspace.Document
 * @see Workspace.Page
 * @see Workspace.Slot
 * @see Workspace.MainElement
 * 
 * @author Anagnosti
 *
 */
public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener{
	
	private Object stavka=null;
    private JTextField edit=null;
    
	public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
		
		stavka=arg1;
		
		edit=new JTextField(arg1.toString());
		edit.addActionListener(this);
		return edit;
	}
	


	public boolean isCellEditable(EventObject arg0) {
		
		if (arg0 instanceof MouseEvent)			
			if (((MouseEvent)arg0).getClickCount()==3){
		
				return true;
			}
		return false;
	}
	
	
	

	public void actionPerformed(ActionEvent e){
		
		if (stavka instanceof Project){
			((Project)stavka).setName(e.getActionCommand());
		}else
		if (stavka instanceof Document){
			((Document)stavka).setName(e.getActionCommand());
			for(Project p : View.get().getModel().getWorkspaceModel().getWorkspace().getProjects())
			{
				p.update();
			}
		}else
			if (stavka instanceof Page){
			((Page)stavka).setName(e.getActionCommand());
		}
			else if (stavka instanceof Slot){
				((Slot)stavka).setName(e.getActionCommand());
			}
		
		if (stavka instanceof Element)
			((Element)stavka).setName(e.getActionCommand());
		
		try {
			stopCellEditing();
		} catch (Exception e1) {}
	}
      //posle promene imena ili dijagrama treba obezbediti i promenu imena u CentralView-u  

}
