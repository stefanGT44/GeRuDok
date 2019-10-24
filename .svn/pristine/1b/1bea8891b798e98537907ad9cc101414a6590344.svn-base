package GUI_Elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;

import DataView.ElementView;
import MVC.View;
import StateActions.SelectState;
import StateActions.State;
import Workspace.Element;
import Workspace.MyOval;
import Workspace.MyRectangle;
/**
 * 
 * Klasa namenjena farbanju, bojenju, ali i dodeljivanju shape-ova na <code>ElementView</code>
 * 
 * 
 * @see GUI_Elements.ElementView
 * @see Workspace.MainElement
 * 
 * @author Anagnosti
 *
 */
@SuppressWarnings("serial")
public class ElementPaintApp extends JComponent {

	public Point startDrag, endDrag;
	public BasicStroke bstroke;

	private ElementView ev;

	public ElementPaintApp(ElementView ev) {
		this.ev = ev;
	}

	public void paint(Graphics g) {

		for (Element el : ev.getMainElement().getPaint()) {
			el.setLineColor(Color.RED);
			el.draw(g);
		}
	}

}
