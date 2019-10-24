package GUI_Elements;

import javax.swing.JToolBar;

import MVC.View;
/**
 * 
 * U toolbar se smestaju akcije newobjectaction, shareaction, importaction.
 * 
 * 
 * @see MVC.View
 * @see Actions.NewObjectAction
 * @see Actions.ShareAction
 * @see Actions.ImportAction
 * 
 * @author Anagnosti
 *
 */
public class ToolBar extends JToolBar{
	
	public ToolBar(){
		super();
		this.setFloatable(false);
		add(View.get().getActionManager().getNewObjectAction());
		addSeparator();
		add(View.get().getActionManager().getShareAction());
		addSeparator();
		add(View.get().getActionManager().getImportAction());
		addSeparator();
		add(View.get().getActionManager().getSwitchWorkspace());
	}

}
