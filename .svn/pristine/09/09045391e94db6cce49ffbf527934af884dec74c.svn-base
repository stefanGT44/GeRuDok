package Actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import MVC.View;
import Workspace.Element;
import commands.DeleteCommand;

/**
 * 
 * Brisu se selektovani oblici, to jest Shape-ovi iz grafickog editora tako sto se skidaju sa <code>ArrayList</code> Shape-ova 
 * koji se prikazuju.
 * 
 * @see GUI_Elements.GraphicEditor
 * @see DataView.ElementView
 * 
 * @author Anagnosti
 *
 */
public class DeleteShapeAction extends AbstractActionManager {

	public DeleteShapeAction() {
		putValue(SMALL_ICON, loadIcon("images/DeleteShapeAction.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete shape");
	}

	
/**
 * 
 * Kreira se <code>ArrayList</code> i u istu se ubacuju selektovani oblici, to jest Shape-ovi iz grafickog editora.
 * Nakon toga se svaki Shape ukloni tako sto se skida sa <code>ArrayList</code> Shape-ova koji se prikazuju.
 * 
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<Element> selected =  View.get().getGraphicEditor().getSelected();

		View.get().getGraphicEditor().getEv().getMainElement().getCommandManager().addCommand(new 
				DeleteCommand(View.get().getGraphicEditor().getEv().getMainElement(),selected));
	}

}
