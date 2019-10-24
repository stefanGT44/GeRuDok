package GUI_Elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JComponent;

import MVC.View;
import StateActions.CircleState;
import StateActions.RectangleState;
import StateActions.SelectState;
import StateActions.State;
import Workspace.Element;
import Workspace.MyOval;
import Workspace.MyRectangle;
/**
 * 
 * 
 * 
 * @author Anagnosti
 *
 */
@SuppressWarnings("serial")
public class Paint_App extends JComponent {
	public Point startDrag, endDrag;
	public BasicStroke bstroke;

	public Paint_App() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				View.get().getGraphicEditor().getEv().getMainElement().getStateManager().getCurrentState()
						.mousePressed(e);

			}

			public void mouseReleased(MouseEvent e) {
				View.get().getGraphicEditor().getEv().getMainElement().getStateManager().getCurrentState()
						.mouseReleased(e);
				repaint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				View.get().getGraphicEditor().getEv().getMainElement().getStateManager().getCurrentState()
						.mouseDragged(e);

				revalidate();
				repaint();
			}
		});
	}

	public void paint(Graphics g) {

		State currentSate = View.get().getGraphicEditor().getEv().getMainElement().getStateManager().getCurrentState();
		ArrayList<Element> shapes = View.get().getGraphicEditor().getEv().getMainElement().getPaint();
		ArrayList<Element> selected = View.get().getGraphicEditor().getSelected();
		
		
		if (currentSate instanceof SelectState) {
			for (Element el : shapes) {
				if (selected.contains(el))
					el.setLineColor(Color.LIGHT_GRAY);
				else
					el.setLineColor(Color.RED);
			}
			for (Element pt : shapes) {
				pt.draw(g);
			}
		} else
			for (Element el : shapes) {
				el.setLineColor(Color.RED);
				el.draw(g);
			}

		if (startDrag != null && endDrag != null) {
			if (currentSate instanceof RectangleState) {
				MyRectangle obj = new MyRectangle();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g);
			} else if (currentSate instanceof CircleState) {
				MyOval obj = new MyOval();
				obj.makeObject(startDrag, endDrag);
				obj.draw(g);
			} else if (currentSate instanceof SelectState) {
				MyRectangle obj = new MyRectangle();
				obj.makeObject(startDrag, endDrag);
				float dash1[] = { 10.0f };
				BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
						0.0f);
				Graphics2D gr2d = (Graphics2D) g;
				gr2d.setStroke(dashed);
				obj.drawDragged(g);
			}
		}

	}
}
