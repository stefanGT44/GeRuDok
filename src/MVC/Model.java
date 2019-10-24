package MVC;
/**
 * 
 * Klasa koja povezuje vizuelni deo drveta sa strukturom, to jest podacima drveta.
 * 
 * 
 * @see MVC.View
 * 
 * 
 * @author Anagnosti
 *
 */
public class Model {

	private WorkspaceTree workspaceTree;
	private WorkspaceModel workspaceModel;

	public Model() {
		initializeWorkspaceTree();
		System.out.println("Model initialized...");
	}

	public void initializeWorkspaceTree() {
		workspaceTree = new WorkspaceTree();
		workspaceModel = new WorkspaceModel();
		workspaceTree.setModel(workspaceModel);
	}

	public WorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}

	public WorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}

}
