package Actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import DataView.PageView;
import DataView.SlotView;
import MVC.View;
import Workspace.Page;
import Workspace.Slot;
/**
 * 
 * Klasa za kreiranje novog slota.
 * 
 * @see DataView.Slot
 * @see Actions.NewObjectAction
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class NewSlotAction extends AbstractActionManager{

	private PageView pageView = null;
	
	public NewSlotAction() {
		
		putValue(SMALL_ICON, loadIcon("images/addSlotIcon.png"));
		putValue(NAME, "New Slot");
		putValue(SHORT_DESCRIPTION, "New Slot");
	}
/**
 * 
 * Poziva se add metoda iz interfejsa <code>DataType</code>.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(pageView == null)//ako je klik na workspace
		{
			Object p = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
			
			if (p instanceof Page)
			{
				Page page = (Page)p;
				page.add();
				
				SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
				View.get().getModel().getWorkspaceTree().expandRow(View.get().getModel().getWorkspaceTree().getSelectionRows()[0]);
			}
		}
		else//ako je klick na PageView
		{
			Page page = pageView.getPage();
			page.add();
			/*SlotView slotView = new SlotView("slot - " + pageView.getPage().getSlots().size()+1);
			Slot slot = slotView.getSlot();
			
			pageView.getPage().addSlot(slotView);
			slotView.setLocation();*/
			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
		}
		
	}

	public void setPageView(PageView pageView) {
		this.pageView = pageView;
	}
	
	

}
