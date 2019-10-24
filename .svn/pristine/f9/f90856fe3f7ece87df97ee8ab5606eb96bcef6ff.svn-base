package GUI_Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import DataView.ElementView;
import MVC.View;
import Workspace.Element;
import commands.CommandManager;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
/**
 * 
 * Popup prozor u kome moze da se dodaju shape-ovi, koji poseduje toolbar na kome se nalaze akcije koje mogu da aktiviraju
 * odredjen state i na taj nacin se mogu dodavati shapeovi, brisu, selektuju, cut,copy,paste-uju na panel od graphics editora
 * koji je isti kao panel elementview-a i sve sto se na njemu radi radi se na trenutno dodeljenom elementview-u.
 * 
 * 
 * @see DataView.ElementView
 * @see StateActions.CircleState
 * @see StateActions.PasteState
 * @see StateActions.RectangleState
 * @see StateActions.SelectState
 * @see StateActions.State
 * @see StateActions.StateManager
 * @see Actions.Cut
 * @see Actions.Copy
 * @see Actions.Paste
 * @see Actions.Delete
 * @see Actions.Undo
 * @see Actions.Redo
 * @see Actions.Select
 * @see Actions.RectangleAction
 * @see ACtions.CircleAction
 * 
 * @author Anagnosti
 *
 */
@SuppressWarnings("serial")
public class GraphicEditor extends JFrame {

	private Color selectColor = Color.RED;

	private JPanel contentPane;
	private GraphicEditor frame;
	private JPanel panel1 = new JPanel();
	private JToolBar toolbar = new JToolBar();
	private ElementView ev;
	private Paint_App paintApp;
	private ArrayList<Element> selected = new ArrayList<>();
	private ArrayList<Element> copy = new ArrayList<>();
	private Point selectStart = new Point(0, 0);
	private Point selectEnd = new Point(0, 0);

	public GraphicEditor() {
		selected = new ArrayList<Element>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Graphics creator");
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(400, 350));
		toolbar.add(View.get().getActionManager().getRectangleAction());
		toolbar.add(View.get().getActionManager().getCircleAction());
		toolbar.add(View.get().getActionManager().getDeleteShapeAction());
		toolbar.add(View.get().getActionManager().getUndo());
		toolbar.add(View.get().getActionManager().getRedo());
		toolbar.add(View.get().getActionManager().getCutAction());
		toolbar.add(View.get().getActionManager().getCopy());
		toolbar.add(View.get().getActionManager().getPaste());
		toolbar.add(View.get().getActionManager().getSelect());
		toolbar.setFloatable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		BoxLayout vbox = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
		contentPane.setLayout(vbox);

		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(350, 30));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel.setBackground(Color.darkGray);

		contentPane.add(toolbar);

		contentPane.add(Box.createVerticalStrut(10));

		panel1.setLayout(new BorderLayout(0, 0));
		panel1.setBackground(Color.WHITE);

		try {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image icon = kit.getImage("src/TreeConfig/images/graphicEditor.png");
			setIconImage(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}

		paintApp = new Paint_App();
		panel1.add(paintApp, BorderLayout.CENTER);
		validate();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				selected.clear();
				super.windowClosing(arg0);
			}

		});
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public ElementView getEv() {
		return ev;
	}

	public void setEv(ElementView ev) {
		this.ev = ev;
	}

	public Paint_App getPaintApp() {
		return paintApp;
	}

	public Color getSelectColor() {
		return selectColor;
	}

	public void setSelectColor(Color selectColor) {
		this.selectColor = selectColor;
	}

	public GraphicEditor getFrame() {
		return frame;
	}

	public void setFrame(GraphicEditor frame) {
		this.frame = frame;
	}

	public ArrayList<Element> getSelected() {
		return selected;
	}

	public void setSelected(ArrayList<Element> selected) {
		this.selected = selected;
	}

	public ArrayList<Element> getCopy() {
		return copy;
	}

	public void setCopy(ArrayList<Element> copy) {
		this.copy = copy;
	}

	public Point getSelectStart() {
		return selectStart;
	}

	public void setSelectStart(Point selectStart) {
		this.selectStart = selectStart;
	}

	public Point getSelectEnd() {
		return selectEnd;
	}

	public void setSelectEnd(Point selectEnd) {
		this.selectEnd = selectEnd;
	}
	
	public void update(){
		revalidate();
		repaint();
	}
	
	public void setUndoRedo(){
		ev.getMainElement().getCommandManager().setIcons();
	}
}