package Workspace;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import DataView.ProjectView;
import MVC.View;
/**
 * 
 * Predstavlja koren, to jest root stabla. Sadrzi lokaciju trenutnoaktivnog workspace-a, kao listu projekata. Povezana je
 * sa WorkspaceView-om preko Observera.
 * 
 * 
 * 
 * @see Workspace.Project
 * @see Workspace.DataType
 * @see MVC.WorkspaceModel
 * 
 * @author Anagnosti
 *
 */
public class Workspace extends Observable implements TreeNode, DataType{

	private ArrayList<Project> projects = new ArrayList<>();
	private String workspaceLocation = "";

	public Workspace() {
		super();
	}
	
	public void add(){
		Project project = new Project();
		project.setLocation(workspaceLocation);
		setChanged();
		notifyObservers(project);
	}

	public void addProject(Project project) {
		if (!projects.contains(project)){
			projects.add(project);
			project.setName("Project - "+projects.size());
		}
	}

	public void removeAllProject() {
		if (projects != null)
			projects.clear();
	}

	@Override
	public Enumeration children() {
		return (Enumeration<Project>) projects;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return projects.get(arg0);
	}

	@Override
	public int getChildCount() {
		return projects.size();
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
	public String toString(){
		return "Workspace";
	}

	@Override
	public int getIndex(TreeNode node) {
		return projects.indexOf((Project)node);
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}
	
	public void importProject(Project project)
	{
		setChanged();
		notifyObservers(project);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public String getWorkspaceLocation() {
		return workspaceLocation;
	}

	public void setWorkspaceLocation(String workspaceLocation) {
		this.workspaceLocation = workspaceLocation;
	}
	
}
