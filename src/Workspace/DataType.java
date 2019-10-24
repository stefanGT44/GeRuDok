package Workspace;
/**
 * 
 * Objedinjuje modele workspace-a, sto omogucuje rekurzivni polimorfizam pri kreiranju novih objekata.
 * 
 * workspace,project,document,page,slot,mainelement,newobjectaction, deleteaction
 * 
 * @see Workspace.Workspace
 * @see Workspace.Document
 * @see Workspace.Page
 * @see Workspace.Slot
 * @see Workspace.MainElement
 * @see Actions.NewObjectAction
 * @see Actions.DeleteAction
 * 
 * 
 * @author Anagnosti
 *
 */
public interface DataType {

	public void add();
	public void delete();
	
}
