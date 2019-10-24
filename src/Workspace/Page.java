package Workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import DataView.SlotView;
import MVC.View;
import MVC.WorkspaceModel;
/**
 * 
 * Predstavlja stranicu koja se nalazi unutar dokumenta, moze da sadrzi nula ili vise slotova, ima svoj naziv,mogu da se dodaju
 * i skidaju slotovi sa nje.
 * 
 * 
 * @see Workspace.DataType
 * @see Workspace.Document
 * @see Workspace.Slot
 * 
 * @author Anagnosti
 *
 */
public class Page extends Observable implements TreeNode, DataType, Serializable {

	private String name;
	private ArrayList<Slot> slots = new ArrayList<>();

	public Page() {

	}

	public void add() {
		addSlot();
	}

	public void addSlot() {
		Slot slot = new Slot();
		slots.add(slot);
		slot.setName("Slot - " + slots.size());

		setChanged();
		notifyObservers(slot);
	}

	public void removeAllSlot() {
		if (slots != null)
			slots.clear();

		setChanged();
		notifyObservers();
	}

	public void setName(String name) {
		this.name = name;

		setChanged();
		notifyObservers();
	}

	@Override
	public Enumeration children() {
		return (Enumeration) slots;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) slots.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return slots.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return slots.indexOf((Slot) node);
	}

	@Override
	public TreeNode getParent() {
		for(Project p : WorkspaceModel.workspace.getProjects())
		{
			for(Document d : p.getDocuments())
			{
				if(d.getPages().contains(this))
					return d;
			}
		}
		
		return null;
	}

	@Override
	public boolean isLeaf() {
		if (slots.isEmpty())
			return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Slot> getSlots() {
		return slots;
	}

	public String toString() {
		return this.name;
	}
	
	public void importSlot(Slot slot)
	{
		setChanged();
		notifyObservers(slot);
	}

	@Override
	public void delete() {
		setChanged();
		notifyObservers("delete");
		
		((Document)this.getParent()).getPages().remove(this);
	}

}