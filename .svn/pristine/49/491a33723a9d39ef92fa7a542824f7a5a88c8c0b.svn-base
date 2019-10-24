package GUI_Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import MVC.View;
/**
 * 
 * Panel cija se moze lokacija menjati dragovanjem, moze se resize-ovati, koristi akcije 
 * <code>mouseAdapterRP</code>, <code>MouseMotionAdapterRP</code>
 * 
 * 
 * @see DataView.ElementView
 * @see Actions.mouseAdapterRP
 * @see Actions.MouseMotionAdapterRP
 * 
 * @author Anagnosti
 *
 */
public class ResizablePanel extends JLayeredPane{

	public int dX, dY;
	public boolean drag = false;
	public Point dragLocation = new Point();

	public ResizablePanel(int width, int height) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(new Dimension(width, height));

		this.addMouseListener(View.get().getActionManager().getMouseAdapterRP());

		this.addMouseMotionListener(View.get().getActionManager().getMouseMotionAdapterRP());
	}

}
