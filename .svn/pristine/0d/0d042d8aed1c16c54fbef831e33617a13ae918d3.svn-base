package StateActions;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import MVC.View;
import Workspace.Element;
import commands.PasteCommand;
/**
 * 
 * 
 * Ppravljenje kopiranih objekata koji su bili selektovani i prikazivanje na graphicseditoru i elementviewu.
 * 
 * 
 * @see GUI_Elements.GraphicEditor
 * @see DataView.ElementView
 * @see commands.PasteCommand
 * @see StateActions.StateManager
 * 
 * @author Anagnosti
 *
 */
public class PasteState extends State implements Serializable {

	public void mousePressed(MouseEvent e) {
		if (View.get().getGraphicEditor().getCopy() == null)
			return;

		ArrayList<Element> elements = View.get().getGraphicEditor().getCopy();

		Point p = e.getPoint();
		Point start = View.get().getGraphicEditor().getSelectStart();
		Point end = View.get().getGraphicEditor().getSelectEnd();
		Point delta = new Point(p.x - start.x, p.y - start.y);
		int width = Math.abs(start.x - end.x);
		int height = Math.abs(start.y - end.y);

		ArrayList<Element> temp = new ArrayList<>();
		for (Element el : elements) {
			Element element = el.cloneMe();
			int x = el.getStart().x + delta.x;
			int y = el.getStart().y + delta.y;

			if (start.x < end.x && start.y < end.y) {
				element.setStart(new Point(x - width / 2, y - height / 2));
				element.setEnd(new Point(x - width / 2, y - height / 2));
			}
			
			if(start.x > end.x && start.y < end.y)
			{
				element.setStart(new Point(x + width / 2, y - height / 2));
				element.setEnd(new Point(x + width / 2, y - height / 2));
			}
			
			if(start.x < end.x && start.y > end.y)
			{
				element.setStart(new Point(x - width / 2, y + height / 2));
				element.setEnd(new Point(x - width / 2, y + height / 2));
			}
			
			if(start.x > end.x && start.y > end.y)
			{
				element.setStart(new Point(x + width / 2, y + height / 2));
				element.setEnd(new Point(x + width / 2, y + height / 2));
			}
			temp.add(element);
		}
		View.get().getGraphicEditor().getEv().getMainElement().getCommandManager().addCommand(new 
				PasteCommand(View.get().getGraphicEditor().getEv().getMainElement(),temp));
	}

	public void mouseDragged(MouseEvent e) {
		// TODO: implement
	}

	public void mouseReleased(MouseEvent e) {
		// TODO: implement
	}

}
