package GUI_Elements;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import MVC.View;
import Workspace.Project;
/**
 * 
 * Popup window u koji treba da se unese putanja do workspace-a, gde se bira workspace, moze se kreirati nov ako se zeli.
 * U JTextField se unosi putanja, takodje moze preko browse-a i time ce se izabrana lokacija automatski ucitati u jextfield.
 * klikom na ok se proverava da li postoji folder, ukoliko postoji, upisuje se u workspace putanja tog foldera, importuju se
 * svi projekti iz tog foldera i zatim ovaj prozor nestaje.
 * 
 * @see MVC.View
 * @see WOrkspace.Workspace
 * @see Actions.BrowseAction
 * 
 * @author Anagnosti
 *
 */
public class ChooseWorkspace extends JFrame{
	
	private JPanel panel = new JPanel();
	private JTextField tf = new JTextField();
	private JButton browse = new JButton("Browse");
	private JButton ok = new JButton("Ok");
	private JButton cancel = new JButton("Cancel");
	
	public ChooseWorkspace(){
		this.setTitle("Set up workspace");
		this.setSize(400, 150);
		
		try {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image icon = kit.getImage("src/TreeConfig/images/icon.png");
			setIconImage(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BoxLayout box = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(box);
		
		panel.add(Box.createVerticalStrut(8));
		JPanel pom = new JPanel();
		pom.add(new JLabel("Select a workspace: "));
		pom.add(Box.createHorizontalStrut(250));
		
		panel.add(pom);
		panel.add(Box.createVerticalStrut(5));
		
		JPanel horiz = new JPanel();
		BoxLayout b1 = new BoxLayout(horiz, BoxLayout.X_AXIS);
		horiz.setLayout(b1);
		
		tf.setSize(300, 50);
		horiz.add(Box.createHorizontalStrut(10));
		horiz.add(tf);
		horiz.add(Box.createHorizontalStrut(5));
		horiz.add(browse);
		horiz.add(Box.createHorizontalStrut(10));
		panel.add(horiz);
		
		panel.add(Box.createVerticalStrut(14));
		
		JPanel btns = new JPanel();
		btns.add(Box.createHorizontalStrut(245));
		btns.add(ok);
		btns.add(cancel);
		panel.add(btns);
		
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				View.get().getActionManager().getBrowseAction().setAction("browse");
				View.get().getActionManager().getBrowseAction().actionPerformed(null);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (View.get().isVisible()) dispose();
				else System.exit(0);
			}
		});
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (new File(tf.getText()).exists()){
					
				if (!View.get().getModel().getWorkspaceModel().getWorkspace().getWorkspaceLocation().equals("")){
					ArrayList<Project> tempCopy = new ArrayList<>();
					for (Project project:View.get().getModel().getWorkspaceModel().getWorkspace().getProjects()){
						tempCopy.add(project);
					}
					for (Project project:tempCopy){
						project.delete();
					}
					tempCopy = null;
					SwingUtilities.updateComponentTreeUI(View.get().getModel().getWorkspaceTree());
				}
					
				View.get().getModel().getWorkspaceModel().getWorkspace().setWorkspaceLocation(tf.getText());
				
				File folder = new File(tf.getText());
				File[] listOfFiles = folder.listFiles();

				for (File file : listOfFiles) {
				    if (file.isFile()) {
				    	String[] str = file.getName().split("\\.");
						if (str[str.length - 1].equals("gpr")) {
							View.get().getActionManager().getImportAction().importuj(file.getAbsolutePath());
						}
				    }
				}
				View.get().setVisible(true);
				dispose();
				}
				else System.out.println("Ne postoji fajl!");
			}
		});
		
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}

}
