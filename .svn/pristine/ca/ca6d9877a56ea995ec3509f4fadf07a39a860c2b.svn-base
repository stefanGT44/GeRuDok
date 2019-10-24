package commands;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.Element;
import Workspace.MainElement;
/**
 * 
 * Lista kopiranih, odnosno cut-ovanih elemenata, se dodaje u listu dece main elementa i samim tim prikazuje na graphics editoru,
 * odnosno element view-u. ukoliko je pozvana undo komanda, skidaju se sa liste dece main elementa, odnosno sa graphics editora i
 * element view-a.
 * 
 * 
 * @see commands.AbstractCommand
 * @see commands.CommandManager
 * @see StateActions.PasteState
 * @see Workspace.MainElement
 * @see Workspace.Element
 * 
 * 
 * 
 * @author Anagnosti
 *
 */
public class PasteCommand extends AbstractCommand implements Serializable{
	
	private MainElement mainElement;
	private ArrayList<Element> elements = new ArrayList<>();

	public PasteCommand(MainElement mainElement, ArrayList<Element> elements) {
		super();
		this.mainElement = mainElement;
		for(Element el : elements)
		{
			this.elements.add(el);
		}
	}

	@Override
	public void doCommand() {
		for (Element element:elements){
			View.get().getGraphicEditor().getEv().getMainElement().getPaint().add(element);
		}
		View.get().getGraphicEditor().getEv().getMainElement().update();
		View.get().getGraphicEditor().update();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

	@Override
	public void undoCommand() {
		for (Element element:elements){
			View.get().getGraphicEditor().getEv().getMainElement().getPaint().remove(element);
		}
		View.get().getGraphicEditor().getEv().getMainElement().update();
		View.get().getGraphicEditor().update();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

}
