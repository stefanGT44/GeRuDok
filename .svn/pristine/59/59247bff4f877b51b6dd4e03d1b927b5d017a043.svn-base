package DataView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextPane;
import GUI_Elements.ElementPaintApp;
import GUI_Elements.ResizablePanel;
import MVC.View;
import Workspace.MainElement;
/**
 * 
 * Predstavlja viewer main elementa, observer glavnog, to jest main elementa. Pozivaju se akcije MAdapter, mouseAdapterRP,
 * mouseMotionAdapterRP.Pri pozivu se model promeni, zatim poziva update od elementview-a i time se  regulisu promene.
 *  Na <code>ElementView</code> se prikazuju <code>MyRectangle</code> i <code>MyOval</code>, to jest njegova deca.
 * 
 * @see Actions.MAdapter
 * @see Actions.mouseAdapterRP
 * @see Actions.mouseMotionAdapterRP
 * 
 * @author Anagnosti
 *
 */
public class ElementView extends ResizablePanel implements Observer{
	
	private MainElement mainElement;
	private boolean copy = false;
	private ElementPaintApp paintApp;
	private JTextPane textPane;

	public ElementView(MainElement mainElement) {
		super(300, 90);
		this.mainElement = mainElement;
		this.mainElement.addObserver(this);
		setLocation(5, 5);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);

		textPane = new JTextPane();

		this.setLayout(new BorderLayout(0, 0));
		paintApp = new ElementPaintApp(this);
		this.add(paintApp, BorderLayout.CENTER);

		addMouseListener(View.get().getActionManager().getmAdapter());
		this.update(null, null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 != null)
			if(arg1.equals("delete"))
			{
				SlotView sv = ((SlotView)this.getParent());
				sv.getElementViews().remove(this);
				sv.remove(this);
				sv.repaint();
				sv.getSlot().setType("");
				return;
			}
		
		if (mainElement.getType().equals("image")) {
			paintApp.paint(null);
			revalidate();
			repaint();
			return;
		}

		if (this.getComponent(0) == paintApp) {
			this.remove(paintApp);

			View.get().getTextEditor().setTextPane(textPane);
			textPane.setDocument(mainElement.getTxtDocument());

			View.get().getTextEditor().setElementView(this);
			View.get().getTextEditor().setTextPane(textPane);
			textPane.setEditable(false);
			this.setLayout(new BorderLayout());
			this.add(textPane, BorderLayout.CENTER);

			textPane.addMouseListener(View.get().getActionManager().getmAdapter());
			textPane.addMouseListener(View.get().getActionManager().getMouseAdapterRP());
			textPane.addMouseMotionListener(View.get().getActionManager().getMouseMotionAdapterRP());
		}

		textPane.revalidate();
		textPane.repaint();
		revalidate();
		repaint();
	}

	public MainElement getMainElement() {
		return mainElement;
	}

	public void setMainElement(MainElement mainElement) {
		this.mainElement = mainElement;
	}

	public boolean isCopy() {
		return copy;
	}

	public void setCopy(boolean copy) {
		this.copy = copy;
	}

	public ElementPaintApp getPaintApp() {
		return paintApp;
	}

	public void setPaintApp(ElementPaintApp paintApp) {
		this.paintApp = paintApp;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

}