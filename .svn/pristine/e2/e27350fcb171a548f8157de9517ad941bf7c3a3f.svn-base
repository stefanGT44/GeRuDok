package Actions;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;

import DataView.ElementView;
import DataView.PageView;
import DataView.SlotView;
import GUI_Elements.ResizablePanel;

/**
 * 
 * Omogucava se pamcenje pocetnih koordinata, drag-ovanje <code>JTextPane</code> ili <code>ElementView</code> u zavisnosti od
 * toga sta se selektuje,kao i pamcenje krajnjih koordinata i samim tim i promena koordinata. 
 * 
 * @see DataView.ElementView
 * @see javax.swing.JTextPane
 * @see Actions.MouseMotionAdapterRP
 * 
 * @author Anagnosti
 *
 */
public class mouseAdapterRP extends MouseAdapter {

/**
 * 
 * Pri klikom na <code>JTextPane</code> i/ili <code>ElementView</code>, pri aktivaciji metode <code>mousePressed</code>, 
 * imamo koordinate <code>ElementView</code>, to jest <code>JTextPane</code>. Pri pritisku se koordinate te pocetne postave,
 * kao i da je <code>drag==true</code> i dok je <code>drag==true</code>, izvrsavaju se metode u klasi <code>MouseMotionAdapterRP</code>.
 * U trenutku kada je mis released, posalje se drag da je false i izvrsi se update <code>ElementView</code>, odnosno 
 * <code>JTextPane</code>, u zavisnosti od toga na cime je akcija bila izvrsena.
 * 
 * 
 */
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof ResizablePanel) {
			ResizablePanel res = (ResizablePanel) e.getSource();

			if (res.contains(e.getPoint())) {
				res.dX = e.getLocationOnScreen().x - res.getX();
				res.dY = e.getLocationOnScreen().y - res.getY();
			}
			res.dragLocation = e.getPoint();
			if (res.dragLocation.getX() > res.getWidth() - 10 && res.dragLocation.getY() > res.getHeight() - 10)
				res.drag = true;
			if (!res.drag)
				res.setBackground(Color.GRAY);

			if (e.getSource() instanceof SlotView) {
				PageView pv = (PageView) ((SlotView) e.getSource()).getParent();
				SlotView sv = (SlotView) e.getSource();

				pv.update(null, pv.getSlotViews().indexOf(sv));
			}
		}

		if (e.getSource() instanceof JTextPane) {
			ElementView res = ((ElementView) ((JTextPane) e.getSource()).getParent());

			if (res.contains(e.getPoint())) {
				res.dX = e.getLocationOnScreen().x - res.getX();
				res.dY = e.getLocationOnScreen().y - res.getY();
			}
			res.dragLocation = e.getPoint();
			if (res.dragLocation.getX() > res.getWidth() - 10 && res.dragLocation.getY() > res.getHeight() - 10)
				res.drag = true;
			if (!res.drag)
				res.setBackground(Color.GRAY);
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() instanceof ResizablePanel) {
			((ResizablePanel) e.getSource()).drag = false;
			((ResizablePanel) e.getSource()).setBackground(Color.LIGHT_GRAY);
			((ResizablePanel) e.getSource()).revalidate();
			((ResizablePanel) e.getSource()).repaint();
		}

		if (e.getSource() instanceof JTextPane) {
			((ResizablePanel) ((JTextPane) e.getSource()).getParent()).drag = false;
			((ResizablePanel) ((JTextPane) e.getSource()).getParent()).setBackground(Color.LIGHT_GRAY);
			((ResizablePanel) ((JTextPane) e.getSource()).getParent()).revalidate();
			((ResizablePanel) ((JTextPane) e.getSource()).getParent()).repaint();
		}
	}

}
