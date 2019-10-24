package Actions;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import DataView.DocumentView;
import DataView.ElementView;
import DataView.PageView;
import DataView.ProjectView;
import DataView.SlotView;
import MVC.View;
import Workspace.Document;
import Workspace.Project;
/**
 * 
 * Klasa koja sluzi za eksportovanje dokumenta na datu lokaciju. Pokrece browse i preko istog se navigira do lokacije.
 * Metodom <code>Export</code> prenosi serijalizovan dokument na datu lokaciju koja je izabrana preko browse-a.
 * 
 * 
 * @see Actions.BrowseAction
 * @see Workspace.Document
 * 
 * @author Anagnosti
 *
 */
public class ExportDocAction extends AbstractActionManager{	
	
	
	public ExportDocAction() {

		putValue(SMALL_ICON, loadIcon("images/export.png"));
		putValue(NAME, "Export Document");
		putValue(SHORT_DESCRIPTION, "Eport Documetn Action");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		View.get().getActionManager().getBrowseAction().setAction("exportDoc");
		View.get().getActionManager().getBrowseAction().actionPerformed(null);
		
	}
	
	public void export(String location)
	{

		for (ProjectView projectView : View.get().getWorkspaceView().getProjectViews()) {
			projectView.getProject().setSize(projectView.getSize());
			projectView.getProject().setPosition(projectView.getLocation());
			for (DocumentView documentView : projectView.getDocumentViews()) {
				for (PageView pageView : documentView.getPageViews()) {
					for (SlotView slotView : pageView.getSlotViews()) {
						slotView.getSlot().setSize(slotView.getSize());
						slotView.getSlot().setLocation(slotView.getLocation());
						for (ElementView elementView : slotView.getElementViews()) {
							elementView.getMainElement().setSize(elementView.getSize());
							elementView.getMainElement().setLocation(elementView.getLocation());
						}
					}
				}
			}
		}
		
		Document document = (Document)View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		
		File f = new File(location+"\\" + document.getName() + ".gdoc");
		
		ObjectOutputStream oos1 = null;
		try {
			oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			oos1.writeObject(document);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally{
			try {
				oos1.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}

	public void exportAll(String location){
		Project project = (Project)View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		for (ProjectView projectView : View.get().getWorkspaceView().getProjectViews()) {
			projectView.getProject().setSize(projectView.getSize());
			projectView.getProject().setPosition(projectView.getLocation());
			for (DocumentView documentView : projectView.getDocumentViews()) {
				for (PageView pageView : documentView.getPageViews()) {
					for (SlotView slotView : pageView.getSlotViews()) {
						slotView.getSlot().setSize(slotView.getSize());
						slotView.getSlot().setLocation(slotView.getLocation());
						for (ElementView elementView : slotView.getElementViews()) {
							elementView.getMainElement().setSize(elementView.getSize());
							elementView.getMainElement().setLocation(elementView.getLocation());
						}
					}
				}
			}
		}
		for (Document document: project.getDocuments()){
			File f = new File(location+"\\" + document.getName() + ".gdoc");
			
			ObjectOutputStream oos1 = null;
			try {
				oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try{
				oos1.writeObject(document);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			finally{
				try {
					oos1.close();
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	
	
}
