package commands;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.Element;
import Workspace.MainElement;
/**
 * 
 * 
 * Ukoliko postoje selektovani elementi u graphics editoru i klikne se na delete dugme, pravi se nova delete komanda u koju
 * se prosledjuje lista selektovanih dokumenata i mainelement koji sadrzi te elemente, izvrsava se docommand, odnosno ti 
 * elementi se brisu iz liste dece mainelemenata. Samim tim se skidaju sa elementview-a i graphics view-a. Ukoliko se poziva
 * Undo komanda, lista elemenata koji su izbrisani se dodaju nazad u listu dece mainelementa i vraca ih na graphics editor, 
 * odnosno element view.
 * 
 * @see commands.AbstractCommand
 * @see commands.CommandManager
 * @see Workspace.MainElement
 * @see Workspace.Element
 * @see Actions.DeleteShapeAction
 * 
 * 
 * 
 * @author Anagnosti
 *
 */
public class DeleteCommand extends AbstractCommand implements Serializable{
	
	private MainElement mainElement;
	private ArrayList<Element> elements = new ArrayList<>();

	public DeleteCommand(MainElement mainElement, ArrayList<Element> elements) {
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
			View.get().getGraphicEditor().getEv().getMainElement().getPaint().remove(element);
		}
		View.get().getGraphicEditor().getEv().getMainElement().update();
		View.get().getGraphicEditor().update();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

	@Override
	public void undoCommand() {
		for (Element element:elements){
			View.get().getGraphicEditor().getEv().getMainElement().getPaint().add(element);
		}
		View.get().getGraphicEditor().getEv().getMainElement().update();
		View.get().getGraphicEditor().update();
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

}
