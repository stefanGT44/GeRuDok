package DataView;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

import GUI_Elements.ResizablePanel;
import MVC.View;
import Workspace.Document;
import Workspace.Element;
import Workspace.MainElement;
import Workspace.Page;
import Workspace.Project;
import Workspace.Slot;
/**
 * 
 * Predstavlja observer od slota, to jest<code>Slot</code>, regulisu se promene u <code>Update</code> metodi klase <code>SlotView</code>.
 * Sadrzi <code>ElementGView</code> i nalazi se u <code>PageView</code>, <code>Update</code> je zaduzen za kreiranje deteta.
 * 
 * 
 * 
 * @see DataView.ElementView
 * @see DataView.PageView
 * @see Workspace.Element
 * @see Workspace.Page
 * 
 * @author Anagnosti
 *
 */
public class SlotView extends ResizablePanel implements Observer {

	private String name;
	private Slot slot;
	private ArrayList<ElementView> elementViews = new ArrayList<>();
	private boolean copy = false;
	private ArrayList<Point> locations = new ArrayList<>();
	private ArrayList<Dimension> sizes = new ArrayList<>();

	public SlotView(Slot slot) {
		super(350, 200);
		this.slot = slot;
		this.slot.addObserver(this);
		this.name = slot.getName();
		this.setOpaque(true);
	}

	public void setLocation() {
		this.setLocation(10, (this.getParent(slot).getChildCount() - 1) * 30 + 30);
	}

	public Page getParent(Slot slot) {
		for (Project p : View.get().getModel().getWorkspaceModel().getWorkspace().getProjects()) {
			for (Document d : p.getDocuments()) {
				for (Page pag : d.getPages()) {
					if (pag.getSlots().contains(slot)) {
						return pag;
					}
				}
			}
		}
		return null;
	}

	public Slot getSlot() {
		return slot;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg != null) {
			if (arg.equals("delete")) {
				PageView pv = ((PageView) this.getParent());
				pv.getSlotViews().remove(this);
				pv.remove(this);
				pv.repaint();
				return;
			}
		}

		if (arg.equals("share")) {
			locations.clear();
			sizes.clear();
			for (Element element : slot.getElements()) {
				for (ProjectView pv : View.get().getWorkspaceView().getProjectViews())
					for (DocumentView dv : pv.getDocumentViews())
						for (PageView pagV : dv.getPageViews()) {
							for (SlotView slv : pagV.getSlotViews()) {
								for (ElementView ev : slv.getElementViews()) {
									if (ev.getMainElement() == element && !ev.isCopy()) {
										locations.add(ev.getLocation());
										sizes.add(ev.getSize());
									}
								}
							}
						}
			}
			for (int i = 0; i < slot.getElements().size(); i++) {
				ElementView ev = new ElementView((MainElement) slot.getElements().get(i));
				ev.setLocation(locations.get(i));
				ev.setSize(sizes.get(i));
				elementViews.add(ev);
				this.add(ev);
				ev.setCopy(true);

				ev.update(null, null);
			}
		}
		if (arg.equals("relocate")) {
			locations.clear();
			sizes.clear();
			for (ElementView ev : elementViews) {
				locations.add(ev.getLocation());
				sizes.add(ev.getSize());
			}

			for (ProjectView pv : View.get().getWorkspaceView().getProjectViews())
				for (DocumentView dv : pv.getDocumentViews())
					for (PageView pagV : dv.getPageViews())
						for (SlotView slv : pagV.getSlotViews()) {
							if (slv.getSlot() == slot) {
								for (int i = 0; i < slv.getElementViews().size(); i++) {
									slv.getElementViews().get(i).setLocation(locations.get(i));
									slv.getElementViews().get(i).setSize(sizes.get(i));
								}
							}
						}
		}
		if (arg instanceof MainElement) {
			ElementView elementView = new ElementView((MainElement) arg);
			elementViews.add(elementView);
			this.add(elementView);
			if (((MainElement) arg).getLocation() != null)
				elementView.setLocation(((MainElement) arg).getLocation());
			if (((MainElement) arg).getSize() != null)
				elementView.setSize(((MainElement) arg).getSize());
			revalidate();
			repaint();
			SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
			try {
				View.get().getModel().getWorkspaceTree()
						.expandRow(View.get().getModel().getWorkspaceTree().getSelectionRows()[0]);
			} catch (Exception e) {
			}
		}
		if (arg instanceof ElementView) {
			if (!elementViews.contains((ElementView) arg)) {
				elementViews.add((ElementView) arg);
				this.add((ElementView) arg);
				revalidate();
				repaint();
			}
		} else {
			// elementViews.remove((ElementView)arg);
			// this.remove((ElementView)arg);
		}
	}

	public boolean isCopy() {
		return copy;
	}

	public void setCopy(boolean copy) {
		this.copy = copy;
	}

	public ArrayList<ElementView> getElementViews() {
		return elementViews;
	}

	public void setElementViews(ArrayList<ElementView> elementViews) {
		this.elementViews = elementViews;
	}

}