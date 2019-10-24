package DataView;

import java.beans.PropertyVetoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;

import MVC.View;
import Workspace.Project;
import Workspace.Workspace;
/**
 * 
 * Mora extendovati jdesktoppane da bi se prikazao projectview koji extenduje jinternalframe. Sadrzi listu projectview-ova,
 * predstavlja observer workspace-a (workspace modela), prikazuje projectview-ove na sebi, kopirati staro
 * 
 * 
 * @see Workspace.Workspace
 * @see Workspace.Project
 * @see DataView.ProjectView
 * @see MVC.View
 * 
 * @author Anagnosti
 *
 */
public class WorkspaceView extends JDesktopPane implements Observer{
	
	private ArrayList<ProjectView> projectViews = new ArrayList<>();
	private Workspace workspace;

	public WorkspaceView() {
		super();
		workspace = View.get().getModel().getWorkspaceModel().getWorkspace();
		workspace.addObserver(this);
	}

	public ArrayList<ProjectView> getProjectViews() {
		return projectViews;
	}

	public void setProjectViews(ArrayList<ProjectView> projectViews) {
		this.projectViews = projectViews;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Project) {
			
			ProjectView pv = check((Project) arg1);
			if (pv == null) {// pravimo
				View.get().getModel().getWorkspaceTree().addProject((Project)arg1);
				ProjectView projectView = new ProjectView((Project) arg1);
				if (((Project)arg1).getSize()!=null)
					projectView.setSize(((Project)arg1).getSize());
				if (((Project)arg1).getPosition()!=null)
					projectView.setLocation(((Project)arg1).getPosition());	
				projectView.toFront();

				try {
					projectView.setSelected(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			} else {//brisemo 
				projectViews.remove(pv);
				try {
					pv.setClosed(true);
					pv.dispose();
				} catch (PropertyVetoException e) {
					//e.printStackTrace();
				}
			}

		}
	}

	private ProjectView check(Project project) {
		for (ProjectView pv : projectViews)
			if (pv.getProject() == project)
				return pv;

		return null;
	}
}
