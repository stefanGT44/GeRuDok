package Workspace;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import MVC.WorkspaceModel;
/**
 * 
 * Nalazi se unutar workspace-a. U sebi moze da sadrzi nula ili vise dokumenata, share-ovani ili original, mogu u njega da
 * se dodaju i da se brisu dokumenti iz njega, save, saveas, brise, da se doda unutar workspace-a
 * 
 * 
 * @see Workspace.Workspace
 * @see Workspace.Document
 * @see Actions.Save
 * @see Actions.SaveAs
 * @see Actions.Delete
 * @see Workspace.DataType
 * 
 * @author Anagnosti
 *
 */
public class Project extends Observable implements TreeNode, DataType, Serializable {

	
	private ArrayList<Document> documents = new ArrayList<>();
	private String name;

	private Dimension size;
	private Point position;

	private String location = null;

	public Project() {

	}

	@Override
	public void add() {
		addDocument();
	}

	public void addDocument() {
		Document document = new Document();
		documents.add(document);
		if (document.getParent() == null)
			document.setMetaParent(this);
		document.setName("Document - " + documents.size());

		setChanged();
		notifyObservers(document);
	}

	public void addSharedDocument(Document document) {
		documents.add(document);
		if (!document.getName().contains(" - (shared)"))
			document.setName(document.getName() + (" - (shared)"));
		setChanged();
		notifyObservers(document);
	}

	public void removeAllDocument() {
		if (documents != null)
			documents.clear();
		setChanged();
		notifyObservers();
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}

	@Override
	public Enumeration children() {
		return (Enumeration) documents;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) documents.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return documents.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return documents.indexOf((Document) node);
	}

	@Override
	public TreeNode getParent() {
		return WorkspaceModel.workspace;
	}

	@Override
	public boolean isLeaf() {
		if (documents.isEmpty())
			return true;
		else
			return false;
	}

	public String toString() {
		return this.name;
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public String getName() {
		return name;
	}

	public void isFocused(boolean b) {
		setChanged();
		notifyObservers(b);
	}

	public void focusTab(int x) {
		setChanged();
		notifyObservers(x);
	}

	public void update() {
		setChanged();
		notifyObservers();
	}
	
	public void importDocument(Document document)
	{
		setChanged();
		notifyObservers(document);
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public void delete() {
		setChanged();
		notifyObservers("delete");
		WorkspaceModel.workspace.getProjects().remove(this);
	}
	
}
