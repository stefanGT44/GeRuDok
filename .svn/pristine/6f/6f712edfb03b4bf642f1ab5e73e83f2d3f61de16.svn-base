package Actions;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import MVC.View;
/**
 * 
 * Pokrece se pokrece prozor uz pomocu kojeg se moze izabrati lokacija ili fajl iz memorije, u zavisnosti od toga da li je
 * akcija <code>Import</code>, <code>SaveAs</code> ili Browse Workspace u pitanju.
 * 
 * @see Actions.ImportAction
 * @see Actions.SaveAs
 * @see GUI_Elements.ChooseWorkspace
 * 
 * @author Anagnosti
 *
 */
public class BrowseAction implements ActionListener {

	private MyFileChooser chooser;
	private String action;

	@Override
	public void actionPerformed(ActionEvent e) {
		chooser = new MyFileChooser();

		chooser.setDialogTitle("Choose Location");
		chooser.setSelectedFile(new File("D:\\"));

		if (action.equals("exportDoc"))
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		if (action.equals("import"))
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		if (action.equals("importDoc"))
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		if (action.equals("saveAs"))
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (action.equals("browse"))
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (action.equals("deleteProject"))
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		JDialog dialog = chooser.createDialog(null);
		chooser.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser chooser = (JFileChooser) evt.getSource();
				if (JFileChooser.APPROVE_SELECTION.equals(evt.getActionCommand())) {
					dialog.setVisible(false);
					if (action.equals("exportDoc"))
						View.get().getActionManager().getExportDocAction().export(chooser.getSelectedFile() + "");
					if (action.equals("importDoc"))
						View.get().getActionManager().getImportDocAction().importuj(chooser.getSelectedFile() + "");
					if (action.equals("import"))
						View.get().getActionManager().getImportAction().importuj(chooser.getSelectedFile() + "");
					if (action.equals("saveAs"))
						View.get().getActionManager().getSaveAs().save(chooser.getSelectedFile() + "");
					if (action.equals("browse"))
						View.get().getChooseWorkspace().getTf().setText(chooser.getSelectedFile() + "");
					if (action.equals("deleteProject")){
						View.get().getDeleteProjectPopup().setTest(true);
						View.get().getActionManager().getExportDocAction().exportAll(chooser.getSelectedFile() + "");
					}
				} else if (JFileChooser.CANCEL_SELECTION.equals(evt.getActionCommand())) {
					if (action.equals("deleteProject"))
						View.get().getDeleteProjectPopup().setTest(false);
					dialog.setVisible(false);
				}
			}
		});

		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false);
			}
		});

		chooser.showOpenDialog(View.get());

	}

	class MyFileChooser extends JFileChooser {
		public JDialog createDialog(Component parent) throws HeadlessException {
			return super.createDialog(parent);
		}
	}

	public void setAction(String action) {
		this.action = action;
	}

}
