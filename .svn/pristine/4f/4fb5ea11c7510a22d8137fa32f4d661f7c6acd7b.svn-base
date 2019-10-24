package Actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import DataView.ElementView;
import MVC.View;


/**
 * 
 * 
 * Pritiskom na element u aplikaciji, u slucaju da je izabran tip elementa graficki editor, otvara se <code>GraphicsEditor</code>.
 * Ako je izabran tip elementa tekstualni editor, onda se otvara <code>TextEditor</code>. 
 * 
 * 
 * @see GUI_Elements.TextEditor
 * @see GUI_Elements.GraphicEditor
 * @see DataView.ElementView
 * 
 * @author Anagnosti
 *
 */
public class MAdapter extends MouseAdapter {

/**
 * 
 * Pritiskom, to jest klikom na element sa izabranim tipom graficki editor se otvara <code>GraphicsEditor</code>. Ako bi se 
 * pritisnuo element tipa tekstualni editor, prvim klikom na prozor otvorio <code>TextEditor</code>. Nakon iskucanog teksta
 * unutar tekstualnog editora, <code>TextPane</code> iz <code>TextEditor</code> se nalepi na <code>ElementView</code>. 
 * Nakon toga se <code>MAdapter</code> nalepi na <code>TextPane</code> da bi bilo moguce opet otvoriti <code>TextEditor</code>
 * pri otvaranju <code>TextPane</code>
 * 
 */
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof ElementView) {
			ElementView ev = (ElementView) e.getSource();
			if (ev.getMainElement().getType().equals("image")) {
				View.get().getGraphicEditor().setEv(ev);
				View.get().getGraphicEditor().setUndoRedo();
				View.get().getGraphicEditor().setVisible(true);
				View.get().getGraphicEditor().getPanel1().setMaximumSize(new Dimension(ev.getWidth(), ev.getHeight()));
				View.get().getGraphicEditor().getContentPane().add(View.get().getGraphicEditor().getPanel1());
				View.get().getGraphicEditor().setSize(ev.getWidth() + 50, ev.getHeight() + 80);
			} else {

				if (ev.getComponent(0) == ev.getPaintApp()) {
					ev.remove(ev.getPaintApp());

					View.get().getTextEditor().setVisible(true);
					View.get().getTextEditor().setElementView(ev);
					View.get().getTextEditor().setTextPane(ev.getTextPane());
					ev.getTextPane().setEditable(false);
					ev.setLayout(new BorderLayout());
					ev.add(ev.getTextPane(), BorderLayout.CENTER);
				}
			}
		}

		if (e.getSource() instanceof JTextPane) {
			ElementView ev = ((ElementView) ((JTextPane) e.getSource()).getParent());
				View.get().getTextEditor().setVisible(true);
				View.get().getTextEditor().setElementView((ElementView) ((JTextPane) e.getSource()).getParent());
				View.get().getTextEditor().setTextPane(ev.getTextPane());
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof ElementView)
			((ElementView) e.getSource()).setBackground(Color.orange);
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() instanceof ElementView) {
			((ElementView) e.getSource()).setBackground(Color.white);
			((ElementView) e.getSource()).getMainElement().update();
		}

		if (e.getSource() instanceof JTextPane) {
			((ElementView) ((JTextPane) e.getSource()).getParent()).setBackground(Color.white);
			((ElementView) ((JTextPane) e.getSource()).getParent()).getMainElement().update();
		}
	}

}
