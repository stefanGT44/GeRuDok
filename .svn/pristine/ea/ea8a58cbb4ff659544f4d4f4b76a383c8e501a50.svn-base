package Actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import DataView.DocumentView;
import DataView.PageView;
import MVC.View;
import Workspace.Document;
import Workspace.Project;

/**
 * 
 * Kada se desni klik misa realizuje dok se kursor nalazi preko drveta ili na bilo koji element samog drveta, pojavice se 
 * drop-down menu sa daljim opcijama. 
 * 
 * 
 *  
 * @author Anagnosti
 *
 */

public class PopupMenuAction implements MouseListener{

	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object obj = e.getSource();
		
		if(SwingUtilities.isRightMouseButton(e))
		{
			if(obj instanceof PageView)
			{
				View.get().getPopupMenu().processClick(e, obj);
			}
			else
			{
				View.get().getModel().getWorkspaceTree().setSelectionPath(View.get().getModel().getWorkspaceTree().getClosestPathForLocation(e.getX(), e.getY()));
				Object o = View.get().getModel().getWorkspaceTree().getSelectionPath().getLastPathComponent();
				View.get().getPopupMenu().processClick(e, o);
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
