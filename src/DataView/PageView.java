package DataView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import Actions.PopupMenuAction;
import MVC.View;
import Workspace.Document;
import Workspace.Page;
import Workspace.Slot;
/**
 * 
 * Predstavlja observer od stranice, to jest<code>Page</code>, regulisu se promene u <code>Update</code> metodi klase <code>PageView</code>.
 * Sadrzi <code>SlotView</code> i nalazi se u <code>DocumentView</code>, <code>Update</code> je zaduzen za kreiranje deteta.
 * 
 * 
 * @see DataView.SlotView
 * @see DataView.DocumentView
 * @see Workspace.Slot
 * @see Workspace.Document
 * 
 * @author Anagnosti
 *
 */
public class PageView extends JLayeredPane implements Observer {

	private String name;
	private JScrollPane scrollPane;
	private Page page;
	private JLabel title;
	private ArrayList<SlotView> slotViews = new ArrayList<>();
	private ArrayList<Point> locations = new ArrayList<>();
	private ArrayList<Dimension> sizes = new ArrayList<>();
	private Integer front = null;

	public PageView(Page page) {
		this.page = page;
		this.page.addObserver(this);
		scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setBackground(Color.white);
		title = new JLabel();
		this.setLayout(null);
		title.setSize(50, 50);
		title.setLocation(8, -10);
		this.add(title);
		this.setPreferredSize(new Dimension(300, 360));

		addMouseListener(new PopupMenuAction());
		this.setOpaque(true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.title.setText(name);
	}

	public ArrayList<SlotView> getSlotViews() {
		return slotViews;
	}

	public void addSlotView(SlotView slotView) {

		if (slotViews.contains(slotView))
			return;

		this.add(slotView);
		revalidate();
		repaint();

		slotViews.add(slotView);
		this.moveToFront(slotView);
		SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
	}

	public Page getPage() {
		return page;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(arg != null)
			if(arg.equals("delete"))
			{
				for(ProjectView pv : View.get().getWorkspaceView().getProjectViews())
				{
					for(DocumentView dv: pv.getDocumentViews())
					{
						if(dv.getPageViews().contains(this))
						{
							dv.getPanel().remove(this);
							return;
						}
					}
				}
				return;
			}
		
		if (arg == null) {
			this.title.setText(page.getName());
			this.repaint();
			this.revalidate();
			return;
		}
		if (arg.equals("share")) {
			locations.clear();
			sizes.clear();

			for (Slot slot : page.getSlots()) {

				for (ProjectView pv : View.get().getWorkspaceView().getProjectViews())
					for (DocumentView dv : pv.getDocumentViews())
						for (PageView pagV : dv.getPageViews()) {
							for (SlotView slv : pagV.getSlotViews()) {
								if (slv.getSlot() == slot && !slv.isCopy()) {
									locations.add(slv.getLocation());
									sizes.add(slv.getSize());
									front = pagV.getFront();
								}
							}
						}

			}

			for (int i = 0; i < page.getSlots().size(); i++) {
				SlotView sv = new SlotView(page.getSlots().get(i));
				sv.setLocation(locations.get(i));
				sv.setSize(sizes.get(i));
				addSlotView(sv);
				sv.setCopy(true);
				sv.update(null, "share");
			}
			if (front != null)
				update(null, front);
		}

		if (arg.equals("relocate")) {
			locations.clear();
			sizes.clear();
			for (SlotView sv : slotViews) {
				locations.add(sv.getLocation());
				sizes.add(sv.getSize());
			}

			for (ProjectView pv : View.get().getWorkspaceView().getProjectViews())
				for (DocumentView dv : pv.getDocumentViews())
					for (PageView pagV : dv.getPageViews())
						if (pagV.getPage() == page) {
							for (int i = 0; i < pagV.getSlotViews().size(); i++) {
								pagV.getSlotViews().get(i).setLocation(locations.get(i));
								pagV.getSlotViews().get(i).setSize(sizes.get(i));
							}
						}
		}

		if (arg instanceof Integer) {
			front = (Integer) arg;
			for (ProjectView pv : View.get().getWorkspaceView().getProjectViews())
				for (DocumentView dv : pv.getDocumentViews())
					for (PageView pagV : dv.getPageViews())
						if (pagV.getPage() == page) {
							pagV.moveToFront(pagV.getSlotViews().get((Integer) arg));

						}

		}

		if (arg instanceof Slot) {
			SlotView slotView = new SlotView((Slot) arg);
			addSlotView(slotView);
			if (((Slot) arg).getLocation() != null) {
				slotView.setLocation(((Slot) arg).getLocation());
			} else
				slotView.setLocation();
			if (((Slot) arg).getSize() != null)
				slotView.setSize(((Slot) arg).getSize());
			moveToFront(slotView);
			try {
				View.get().getModel().getWorkspaceTree()
						.expandRow(View.get().getModel().getWorkspaceTree().getSelectionRows()[0]);
			} catch (Exception e) {
			}
		}

		if (arg instanceof SlotView)

		{
			if (!slotViews.contains(arg)) {
				addSlotView((SlotView) arg);
			} else {
				this.removeAll();
				slotViews.remove((SlotView) arg);
				for (SlotView s : slotViews) {
					addSlotView((SlotView) arg);

				}
			}
		}

		this.title.setText(page.getName());
		this.repaint();
		this.revalidate();

	}

	public void setFront(int front) {
		this.front = front;
	}

	public Integer getFront() {
		return front;
	}

}