package commands;

import java.awt.Point;
import java.io.Serializable;

import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.Element;
import Workspace.MainElement;
/**
 * 
 * 
 * U njega se dodaju elementi(MyRectangle, MyOval) i MainElement koji sadrzi te elemente, zatim se u zavisnosti od toga koja
 * je komanda pozvana (docommand ili undocommand). U slucaju da je docommand, navedeni elementi se prikazuju na graphics editoru 
 * i elementview-u (dodaju se u listu dece u mainelement-u). U slucaju da je undocommand, oni se skidaju sa liste dece u mainelement-u,
 * te se samim tim brisu sa graphics editor-a i elementview-a.
 * 
 * 
 * @see StateActions.CircleState
 * @see StateActions.RectangleState
 * @see Workspace.MainElement
 * @see commands.AbstractCommand
 * @see commands.CommandManager
 * 
 * @author Anagnosti
 *
 */
public class AddShapeCommand extends AbstractCommand implements Serializable{
	
	private MainElement mainElement;
	private Point lastPosition;
	private Element element;

	public AddShapeCommand(MainElement mainElement, Point lastPosition, Element element) {
		super();
		this.mainElement = mainElement;
		this.lastPosition = lastPosition;
		this.element = element;
	}

	@Override
	public void doCommand() {
		View.get().getGraphicEditor().getEv().getMainElement().getPaint().add(element);
		
		View.get().getGraphicEditor().getEv().getMainElement().update();
		View.get().getGraphicEditor().update();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

	@Override
	public void undoCommand() {
		View.get().getGraphicEditor().getEv().getMainElement().getPaint().remove(element);
		
		View.get().getGraphicEditor().getEv().getMainElement().update();
		View.get().getGraphicEditor().update();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

}
