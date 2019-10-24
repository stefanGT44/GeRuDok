package Workspace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTextPane;
import javax.swing.tree.TreeNode;

import MVC.WorkspaceModel;
import StateActions.StateManager;
import commands.CommandManager;
/**
 * 
 * Element koji se nalazi unutar slota. Moze imati svoj tip, graficki ili tekstualni, moze sadrzati veci broj elemenata(graficki),
 * ako je tip graficki. Ima statemanager i commandmanager koji koristi ukoliko je graficki tip za crtanje, cut copy paste undo redo.
 * Ukoliko je tekstualni, koriste se varijable fontindex, scolor. Takodje sadrzi dimenziju svoju i poziciju na kojoj se
 * nalazi unutar slota. 
 * 
 * 
 * @see Workspace.Element
 * @see Workspace.DataType
 * @see Workspace.Slot
 * @see GUI_Elements.GraphicEditor
 * @see GUI_Elements.TextEditor
 * 
 * @author Anagnosti
 *
 */
public class MainElement extends Element implements Serializable, DataType {

	private ArrayList<Element> paint = new ArrayList<Element>();
	private StateManager stateManager;
	private CommandManager commandManager;

	private javax.swing.text.Document txtDocument;
	private int fontIndex = 5;
	private Color sColor = Color.black;
	
	private Dimension size;
	private Point location;

	public MainElement(String type) {
		this.type = type;
		stateManager = new StateManager();
		commandManager = new CommandManager();

		JTextPane tp = new JTextPane();
		txtDocument = tp.getDocument();
	}

	public void addElement(Element element) {

	}

	public void removeElement(Element element) {

	}

	public ArrayList<Element> getPaint() {
		return paint;
	}

	public void setPaint(ArrayList<Element> paint) {
		this.paint = paint;
	}

	@Override
	public Enumeration children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return paint.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return paint.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return paint.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		for (Project p : WorkspaceModel.workspace.getProjects()) {
			for (Document d : p.getDocuments()) {
				for (Page page : d.getPages()) {
					for (Slot slot : page.getSlots()) {
						if (slot.getElements().contains(this))
							return slot;
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isLeaf() {
		if (paint.isEmpty())
			return true;
		else
			return false;
	}

	public String toString() {
		return this.name;
	}

	public void startPasteState() {
		stateManager.setPasteState();
	}

	public void startRectangleState() {
		stateManager.setRectangleState();
	}

	public void startCircleState() {
		stateManager.setCircleState();
	}

	public void startSelectState() {
		stateManager.setSelectState();
	}

	public StateManager getStateManager() {
		return stateManager;
	}

	public void update() {
		setChanged();
		notifyObservers();
	}

	public int getFontIndex() {
		return fontIndex;
	}

	public void setFontIndex(int fontIndex) {
		this.fontIndex = fontIndex;
	}

	public Color getsColor() {
		return sColor;
	}

	public void setsColor(Color sColor) {
		this.sColor = sColor;
	}

	public javax.swing.text.Document getTxtDocument() {
		return txtDocument;
	}

	public void setTxtDocument(javax.swing.text.Document txtDocument) {
		this.txtDocument = txtDocument;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		setChanged();
		notifyObservers("delete");
		
		((Slot)this.getParent()).getElements().remove(this);
		
	}
	
	

}
