package Workspace;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import MVC.WorkspaceModel;
/**
 * 
 * Predstavlja model graficke komponente koja moze da se doda na stranicu, to jest pageview. Sadrzi listu elemenata(mainelemenata),
 * odredjenog je tipa i cuva lokaciju i velicinu svog viewer-a (slotview) zbog importovanja.
 * 
 * 
 * @see Workspace.Page
 * @see Workspace.Element
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class Slot extends Observable implements TreeNode, DataType, Serializable {
	
	private String type = "";
	private String name;
	private Point location;
	private Dimension size;
	private ArrayList<Element> elements = new ArrayList<>();

	public Slot() {
	}

	public void add() {
		
	}

	public void addElement(String type) {
		if (!this.type.equals("") && !this.type.equals(type))
			return;

		this.type = type;

		MainElement mainElement = new MainElement(this.type);
		elements.add(mainElement);
		mainElement.setName("element");

		setChanged();
		notifyObservers(mainElement);
	}

	public void removeAllElement() {
		if (elements != null)
			elements.clear();
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Enumeration children() {
		return (Enumeration) elements;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) elements.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return elements.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return elements.indexOf((Element) node);
	}

	@Override
	public TreeNode getParent() {
		for(Project p : WorkspaceModel.workspace.getProjects())
		{
			for(Document d : p.getDocuments())
			{
				for(Page pag: d.getPages())
				{
					if(pag.getSlots().contains(this))
					{
						return pag;
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public boolean isLeaf() {
		if (elements.isEmpty())
			return true;
		return false;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	@Override
	public String toString() {
		return name;
	}

	public void update() {
		setChanged();
		notifyObservers();
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}
	
	public void importElement(MainElement mainElement)
	{
		setChanged();
		notifyObservers(mainElement);
	}

	@Override
	public void delete() {
		setChanged();
		notifyObservers("delete");
		
		((Page)this.getParent()).getSlots().remove(this);
	}

}