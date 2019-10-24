package StateActions;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GUI_Elements.GraphicEditor;
import MVC.View;
import Workspace.MainElement;
import Workspace.MyOval;
import Workspace.MyRectangle;
import commands.AddShapeCommand;
/**
 * 
 * Ukoliko je current state u state manager-u setovan na circle state, onda se poziva mousepressed od cirlcestate.
 * U mousepressed se pravi nov myoval i prikazuje se u graphics editoru i main elementu
 * 
 * 
 * @see StateActions.StateManager
 * @see Workspace.MainElement
 * @see GUI_Elements.GraphicEditor
 * @see Workspace.MyOval
 * @see commands.CommandManager
 * @see commands.AddShapeCommand
 * 
 * @author Anagnosti
 *
 */
public class CircleState extends State implements Serializable{

	public void mousePressed(MouseEvent e) {
		GraphicEditor editor = View.get().getGraphicEditor();
		Point p = new Point(e.getPoint());
		editor.setSelectColor(Color.RED);
		
		MyOval obj = new MyOval();
		obj.makeObject(p, p);
		
		MainElement mev = View.get().getGraphicEditor().getEv().getMainElement();
		mev.getCommandManager().addCommand(new AddShapeCommand(mev,p,obj));
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}
}