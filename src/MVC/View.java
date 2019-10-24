package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Actions.ActionManager;
import DataView.WorkspaceView;
import GUI_Elements.ChooseWorkspace;
import GUI_Elements.DeleteProjectPopup;
import GUI_Elements.ElementPopupChooser;
import GUI_Elements.GraphicEditor;
import GUI_Elements.Menu;
import GUI_Elements.PopupMenu;
import GUI_Elements.TextEditor;
import GUI_Elements.ToolBar;
/**
 * 
 * Glavni prozor aplikacije. Singleton je. Pristupamo actionmanageru preko view-a, na njoj se nalazi menu, toolbar,
 * workspaceview koji predstavlja jdeskttoppane koji podrzava multidokumentalni interfejs, takodje prikazuje workspace tree
 * (vizuelni deo drveta, stabla). 
 * 
 * @author Anagnosti
 *
 */
public class View extends JFrame {

	public static View instance;
	
	private ChooseWorkspace chooseWorkspace;
	private DeleteProjectPopup deleteProjectPopup;

	public ToolBar toolbar;

	private Model model;
	private Menu menu;

	private JPanel mainPanel;
	private WorkspaceView workspaceView;

	private PopupMenu popupMenu;
	private ElementPopupChooser elementPopup;
	private GraphicEditor graphicEditor;
	private TextEditor textEditor;
	private ActionManager actionManager;
	

	public static View get() {
		if (instance == null) {
			instance = new View();
		}
		return instance;
	}

	private View() {
		instance = this;
		actionManager = new ActionManager();
		System.out.println("View initialized...");
	}

	public void initModel(Model model) {
		this.model = model;
		showScreen();
	}

	private void showScreen() {
		setIcon("src/TreeConfig/images/icon.png");
		this.setTitle("GeRuDok");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel(this);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		toolbar = new ToolBar();
		graphicEditor = new GraphicEditor();
		textEditor = new TextEditor();
		elementPopup = new ElementPopupChooser();

		mainPanel.add(toolbar, BorderLayout.NORTH);

		JScrollPane scroll = new JScrollPane(View.get().getModel().getWorkspaceTree());
		scroll.setMinimumSize(new Dimension(150, 150));
		popupMenu = new PopupMenu();
		popupMenu.add(scroll);
		workspaceView = new WorkspaceView();
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, workspaceView);
		split.setDividerLocation(250);

		workspaceView.setBackground(Color.GRAY);

		mainPanel.add(split, BorderLayout.CENTER);

		menu = new Menu();
		this.setJMenuBar(menu);

		this.setContentPane(mainPanel);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		if (screen.getWidth() < 1600 || screen.getHeight() < 900)
			this.setSize(800, 600);
		else
			this.setSize(1600, 900);
		
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		chooseWorkspace = new ChooseWorkspace();
		deleteProjectPopup = new DeleteProjectPopup();
	}

	public void setLookAndFeel(Component c) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		SwingUtilities.updateComponentTreeUI(c);
	}

	private void setIcon(String str) {
		try {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image icon = kit.getImage(str);
			setIconImage(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ----------------GETERS AND
	// SETTERS-------------------------------------------------
	public Model getModel() {
		return model;
	}

	public ToolBar getToolbar() {
		return toolbar;
	}

	public Menu getMenu() {
		return menu;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public WorkspaceView getWorkspaceView() {
		return workspaceView;
	}

	public PopupMenu getPopupMenu() {
		return popupMenu;
	}

	public ElementPopupChooser getElementPopup() {
		return elementPopup;
	}

	public GraphicEditor getGraphicEditor() {
		return graphicEditor;
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public TextEditor getTextEditor() {
		return this.textEditor;
	}
	
	public ChooseWorkspace getChooseWorkspace() {
		return chooseWorkspace;
	}

	public DeleteProjectPopup getDeleteProjectPopup() {
		return deleteProjectPopup;
	}
	
}
