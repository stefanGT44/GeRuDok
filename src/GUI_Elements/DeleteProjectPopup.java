package GUI_Elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MVC.View;
import Workspace.Project;

public class DeleteProjectPopup extends JDialog {

	private JPanel panel = new JPanel();
	private JCheckBox checkBox = new JCheckBox("Export documents from this project.");
	private JButton ok = new JButton("Ok");
	private JButton cancel = new JButton("Cancel");
	private boolean test;

	public DeleteProjectPopup() {
		super(View.get());
		this.setModal(true);
		this.setTitle("Delete Project");
		this.setSize(400, 160);

		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);

		panel.add(Box.createVerticalStrut(10));
		JPanel pom = new JPanel();
		// pom.add(Box.createHorizontalStrut(10));
		pom.add(new JLabel("<html>The project you want to delete contains document(s).<br>"
				+ "Do you want to export the document(s)?</html>"));
		pom.add(Box.createHorizontalStrut(80));
		panel.add(pom);
		// panel.add(Box.createVerticalStrut(10));

		JPanel pom1 = new JPanel();
		//BoxLayout box2 = new BoxLayout(pom1, BoxLayout.X_AXIS);
		//pom1.setLayout(box2);
		pom1.add(checkBox);
		pom1.add(Box.createHorizontalStrut(120));
		panel.add(pom1);
		// panel.add(Box.createVerticalStrut(1));

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				test = true;
				if (checkBox.isSelected()){
					View.get().getActionManager().getBrowseAction().setAction("deleteProject");
					View.get().getActionManager().getBrowseAction().actionPerformed(null);
				}
				if (test)
				((Project)View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent()).delete();
				setVisible(false);
			}
		});

		JPanel pom2 = new JPanel();
		BoxLayout hbox = new BoxLayout(pom2, BoxLayout.X_AXIS);
		pom2.setLayout(hbox);
		pom2.add(Box.createHorizontalStrut(200));
		pom2.add(cancel);
		pom2.add(ok);
		panel.add(pom2);

		this.add(panel);
		this.setLocationRelativeTo(null);
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

}
