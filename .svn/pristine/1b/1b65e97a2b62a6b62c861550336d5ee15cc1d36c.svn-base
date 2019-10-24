package GUI_Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import MVC.View;
import MVC.WorkspaceModel;
import Workspace.Document;
import Workspace.Project;
/**
 * 
 * Popup window za shareovanje dokumenta. Pojavi se kad se klikne na akciju share-ovanja dokumenta. u tom prozoru se pojavi
 * lista projekata koji ne sadrze taj dokument koji treba biti share-ovan.
 * 
 * 
 * @see MVC.View
 * @see Workspace.Project
 * @see Workspace.Document
 * 
 * @author Anagnosti
 *
 */
public class ShareWith extends JDialog{
	
	public ShareWith(){
		super(View.get());
		this.setTitle("Share");
		this.setModal(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("  Chose a Project: ");
		label.setMinimumSize(new Dimension(100, 25));
		label.setFont(new Font("", 1, 14));
		
		Document doc = (Document) View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		ArrayList<Project> projects = new ArrayList<>();
		boolean test = false;
		for(Project p : WorkspaceModel.workspace.getProjects())
		{
			for(Document d : p.getDocuments())
			{
				if(d == doc)
					test = true;
			}
			if(test == false)
				projects.add(p);
			test = false;
		}
		
		projects.remove(doc.getParent());

		JList lista = new JList(projects.toArray());

		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JButton bt = new JButton("<html><b>SHARE</html>");
		bt.setOpaque(true);
		bt.setBackground(Color.BLACK);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lista.getSelectedValue() == null)
					return;

				Project project = (Project) lista.getSelectedValue();
				Document doc = (Document) View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
				doc.shareDocument(project);
				dispose();
			}
		});
		
		panel.add(label, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(bt, BorderLayout.SOUTH);
		this.add(panel);
		this.setSize(new Dimension(150,250));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
