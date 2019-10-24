package TreeConfig;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import DataView.DocumentView;
import DataView.PageView;
import DataView.ProjectView;
import MVC.View;
import Workspace.Document;
import Workspace.Element;
import Workspace.MainElement;
import Workspace.MyOval;
import Workspace.MyRectangle;
import Workspace.Page;
import Workspace.Project;
import Workspace.Slot;
/**
 * 
 * Renderuje prikaz stabla i u ovoj klasi se namestaju ikonice nasih datatype-ova.
 * 
 * 
 * @see MVC.WorkspaceTree
 * @see Workspace.Project
 * @see Workspace.Document
 * @see Workspace.Page
 * @see Workspace.Slot
 * @see Workspace.MainElement
 * @see Workspace.MyOval
 * @see Workspace.MyRectangle
 * 
 * @author Anagnosti
 *
 */
public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer {

	public WorkspaceTreeCellRendered() {

	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof Document) {
			URL imageURL = getClass().getResource("images/document.png");
			for (ProjectView pv:View.get().getWorkspaceView().getProjectViews()){
				for (DocumentView dv: pv.getDocumentViews()){
						if (dv.getDocument() == (Document)value && dv.isCopy()){
							imageURL = getClass().getResource("images/sharedDocument.png");
						}
						else 
							imageURL = getClass().getResource("images/document.png");
				}
			}
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);

		} else if (value instanceof Project) {
			URL imageURL = getClass().getResource("images/project.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
			}
		else
		{
			if (value instanceof Page) {
				URL imageURL = getClass().getResource("images/page.png");
				Icon icon = null;
				if (imageURL != null)
					icon = new ImageIcon(imageURL);
				setIcon(icon);
				}
			else
			{
				if (value instanceof Slot) {
					String str;
					if(((Slot) value).isLeaf())
						str = "images/slot.png";
					else
					{
						str = "images/" + ((Slot) value).getType() + ".png";  
					}
					URL imageURL = getClass().getResource(str);
					Icon icon = null;
					if (imageURL != null)
						icon = new ImageIcon(imageURL);
					setIcon(icon);
					}
				else 
				{
					if (value instanceof MainElement){
						URL imageURL = null;
						if (((Element) value).getType().equals("text")){
							imageURL = getClass().getResource("images/text.png");
							((Slot)((Element)value).getParent()).setType("text");
						} else if (((Element) value).getType().equals("image")){
							imageURL = getClass().getResource("images/image.png");
							((Slot)((Element)value).getParent()).setType("image");
						}
						Icon icon = null;
						if (imageURL != null)
							icon = new ImageIcon(imageURL);
						setIcon(icon);
					} else {
						if (value instanceof MyRectangle){
							URL imageURL = getClass().getResource("images/square.png");
							Icon icon = null;
							if (imageURL != null)
								icon = new ImageIcon(imageURL);
							setIcon(icon);
						}
						else {
							if (value instanceof MyOval){
								URL imageURL = getClass().getResource("images/circle.png");
								Icon icon = null;
								if (imageURL != null)
									icon = new ImageIcon(imageURL);
								setIcon(icon);
							}
						}
					}
				}
			}
		}

		return this;
	}

}
