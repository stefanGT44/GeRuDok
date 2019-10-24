package Actions;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTextPane;

import DataView.ElementView;
import DataView.PageView;
import DataView.SlotView;
import GUI_Elements.ResizablePanel;

/**
 * 
 * Podesava pomeranje i resize-ovanje <code>JTextPane</code> ili <code>ElementView</code>, u zavisnosti od toga sta je selektovano. 
 * 
 * 
 * @see DataView.ElementView
 * @see javax.swing.JTextPane
 * @see Actions.mouseAdapterRP
 * 
 * @author Anagnosti
 *
 */
public class MouseMotionAdapterRP extends MouseMotionAdapter {

	
	
/**
 * 
 * Lokacija biva setovana nad <code>JTextPane</code> ili <code>ElementView</code>, u slucaju da je <code>drag==false</code>.
 * U slucaju da je <code>drag==true</code>, onda se <code>JTextPane</code> ili <code>ElementView</code> resize-uje.
 * 
 * 
 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() instanceof ResizablePanel) {
			ResizablePanel res = (ResizablePanel) e.getSource();
			if (!res.drag) {
				res.setLocation(e.getLocationOnScreen().x - res.dX, e.getLocationOnScreen().y - res.dY);
				res.dX = e.getLocationOnScreen().x - res.getX();
				res.dY = e.getLocationOnScreen().y - res.getY();
			}
			if (res.drag) {
				if (res.dragLocation.getX() > res.getWidth() - 10 && res.dragLocation.getY() > res.getHeight() - 10) {
					int finWidth = (int) (res.getWidth() + (e.getPoint().getX() - res.dragLocation.getX()));
					int finHeight = (int) (res.getHeight() + (e.getPoint().getY() - res.dragLocation.getY()));
					if (!(finWidth < 50 || finHeight < 50)) {
						res.setSize(finWidth, finHeight);
					}
					res.dragLocation = e.getPoint();
				}
			}

			if (e.getSource() instanceof SlotView) {
				PageView pv = (PageView) ((SlotView) e.getSource()).getParent();
				pv.update(null, "relocate");
			}
			if (e.getSource() instanceof ElementView) {
				SlotView sv = (SlotView) ((ElementView) e.getSource()).getParent();
				sv.update(null, "relocate");
			}

			res.revalidate();
			res.repaint();
		} else {
			ResizablePanel res = ((ResizablePanel) ((JTextPane) e.getSource()).getParent());
			if (!res.drag) {
				res.setLocation(e.getLocationOnScreen().x - res.dX, e.getLocationOnScreen().y - res.dY);
				res.dX = e.getLocationOnScreen().x - res.getX();
				res.dY = e.getLocationOnScreen().y - res.getY();
			}
			if (res.drag) {
				if (res.dragLocation.getX() > res.getWidth() - 10 && res.dragLocation.getY() > res.getHeight() - 10) {
					int finWidth = (int) (res.getWidth() + (e.getPoint().getX() - res.dragLocation.getX()));
					int finHeight = (int) (res.getHeight() + (e.getPoint().getY() - res.dragLocation.getY()));
					if (!(finWidth < 50 || finHeight < 50)) {
						res.setSize(finWidth, finHeight);
					}
					res.dragLocation = e.getPoint();
				}
			}

			SlotView sv = (SlotView) (((JTextPane) e.getSource()).getParent()).getParent();
			sv.update(null, "relocate");

			res.revalidate();
			res.repaint();
		}
	}

	
/**
 * 
 * Ako je kursor postavljen na donji desni ugao, to jest cosak <code>JTextPane</code> i/ili <code>ElementView<code>,
 * ikonica kursora ce se promeniti.
 * 
 * 
 */
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() instanceof ResizablePanel) {
			((ResizablePanel) e.getSource()).dragLocation = e.getPoint();
			if (((ResizablePanel) e.getSource()).dragLocation.getX() > ((ResizablePanel) e.getSource()).getWidth() - 10
					&& ((ResizablePanel) e.getSource()).dragLocation
							.getY() > ((ResizablePanel) e.getSource()).getHeight() - 10) {
				((ResizablePanel) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
			} else
				((ResizablePanel) e.getSource()).setCursor(Cursor.getDefaultCursor());
		} else {

			((ResizablePanel) ((JTextPane) e.getSource()).getParent()).dragLocation = e.getPoint();
			if (((ResizablePanel) ((JTextPane) e.getSource()).getParent()).dragLocation
					.getX() > ((ResizablePanel) ((JTextPane) e.getSource()).getParent()).getWidth() - 10
					&& ((ResizablePanel) ((JTextPane) e.getSource()).getParent()).dragLocation
							.getY() > ((ResizablePanel) ((JTextPane) e.getSource()).getParent()).getHeight() - 10) {
				((ResizablePanel) ((JTextPane) e.getSource()).getParent())
						.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
			} else
				((ResizablePanel) ((JTextPane) e.getSource()).getParent()).setCursor(Cursor.getDefaultCursor());
		}
	}

}
