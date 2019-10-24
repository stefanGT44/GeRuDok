package Workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import DataView.PageView;
import DataView.ProjectView;
import MVC.View;
/**
 * 
 * Document je povezan sa DocumentView preko Observera. Sadrzi listu svojih page-ova, projekta u kojima se nalazi, ima jednog
 * glavnog roditelja (metaparent-a), ima naziv. Moze se deli izmedju veceg broja projekata. Serijalizovan je radi cuvanja 
 * dokumenta u lokalnoj memoriji.
 * 
 * 
 * 
 * @see Workspace.Project
 * @see Workspace.DataType
 * @see Workspace.Page
 * 
 * @author Anagnosti
 *
 */
public class Document extends Observable implements TreeNode, DataType, Serializable {

	private String name;
	private ArrayList<Page> pages = new ArrayList<>();
	private Project metaParent;
	private ArrayList<Project> parents = new ArrayList<>();

	public Document() {

	}

	public void add() {
		addPage();
	}

	public void setMetaParent(Project project) {
		this.metaParent = project;
		parents.add(metaParent);
	}

	public void shareDocument(Project project) {
		if (!parents.contains(project)) {
			parents.add(project);
			project.addSharedDocument(this);
		}
	}

	public void addPage() {
		Page page = new Page();
		pages.add(page);
		page.setName("page - " + pages.size());

		setChanged();
		notifyObservers(page);
	}

	public ArrayList<Project> getParents() {
		return parents;
	}

	public void removeAllPage() {
		if (pages != null)
			pages.clear();

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
		return (Enumeration) pages;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) pages.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return pages.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return pages.indexOf((Page) node);
	}

	@Override
	public TreeNode getParent() {
		return metaParent;
	}

	@Override
	public boolean isLeaf() {
		if (pages.isEmpty())
			return true;
		else
			return false;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Page> getPages() {
		return pages;
	}

	public String toString() {
		return this.name;
	}

	public void update() {
		setChanged();
		notifyObservers();
	}
	
	public void importPage(Page page)
	{
		setChanged();
		notifyObservers(page);
	}

	@Override
	public void delete() {
		setChanged();
		notifyObservers("delete");
		
		for(Project p: parents)
		{
			p.getDocuments().remove(this);
		}
	}

}
