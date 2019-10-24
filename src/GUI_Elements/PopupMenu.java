package GUI_Elements;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

import DataView.PageView;
import MVC.View;
import Workspace.Document;
import Workspace.Element;
import Workspace.Page;
import Workspace.Project;
import Workspace.Slot;
import Workspace.Workspace;
/**
 * 
 * Meni koji se pojavi kad se desnim klikom klikne nad drvetom ili nad pagevew-om i uzavisnosti od toga nad cime je kliknut,
 * pojavljuju se razlicite akcije u njemu. 
 * 
 * 
 * @see Actions.NewProjectAction
 * @see Actions.NewPageAction
 * @see Actions.NewDocumentAction
 * @see Actions.NewElementAction
 * @see MVC.WorkspaceTree
 * 
 * @author Anagnosti
 *
 */
public class PopupMenu extends JPopupMenu {

	
	public void processClick(MouseEvent event, Object o) {

		if (o instanceof Workspace) {
			this.removeAll();
			this.add(View.get().getActionManager().getNewProjectAction());
			this.add(View.get().getActionManager().getImportAction());
		} else {
			if (o instanceof Project) {
				this.removeAll();
				this.add(View.get().getActionManager().getNewDocumentAction());
				this.add(View.get().getActionManager().getSaveAs());
				this.add(View.get().getActionManager().getSave());
				this.add(View.get().getActionManager().getDeleteAction());
				if(((Project)o).getLocation() == null)
					View.get().getActionManager().getSave().setEnabled(false);
				else
					View.get().getActionManager().getSave().setEnabled(true);
				this.addSeparator();
				this.add(View.get().getActionManager().getImportDocAction());
			} else {
				if (o instanceof Document) {
					this.removeAll();
					this.add(View.get().getActionManager().getNewPageAction());
					this.add(View.get().getActionManager().getShareAction());
					this.add(View.get().getActionManager().getDeleteAction());
					this.add(View.get().getActionManager().getExportDocAction());
				} else {
					if (o instanceof Page) {
						this.removeAll();
						this.add(View.get().getActionManager().getNewSlotAction());
						this.add(View.get().getActionManager().getDeleteAction());
					}
					else
					{
						if (o instanceof Slot) {
							this.removeAll();
							this.add(View.get().getActionManager().getNewElementAction());
							this.add(View.get().getActionManager().getDeleteAction());
						}
						else
							if(o instanceof Element)
							{
								this.removeAll();
								this.add(View.get().getActionManager().getDeleteAction());
							}
					}
				}
			}
		}

		if(o instanceof PageView)
		{
			View.get().getActionManager().getNewSlotAction().setPageView((PageView)o);
			this.removeAll();
			this.add(View.get().getActionManager().getNewSlotAction());
			
			View.get().getActionManager().getNewSlotAction().setPageView((PageView)o);
			this.setVisible(true);
			this.show(event.getComponent(), event.getX(), event.getY());
			return;
		}
		else
			View.get().getActionManager().getNewSlotAction().setPageView(null);
		
		this.setVisible(true);
		this.show(View.get().getModel().getWorkspaceTree(), event.getX(), event.getY());
	}

	
	

}
