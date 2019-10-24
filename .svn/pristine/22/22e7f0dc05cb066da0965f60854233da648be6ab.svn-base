package StateActions;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import GUI_Elements.GraphicEditor;
import MVC.View;
import Workspace.Element;
/**
 * 
 * Kreira isprekidani rectangle (pravougaonik) i svi objekti(elementi) koji se nalaze unutar rectangle-a su stavljeni u 
 * listu selektovanih elemenata.
 * 
 * 
 * @see GUI_Elements.GraphicEditor
 * @see StateActions.StateManager
 * @see Workspace.MainElement
 * 
 * @author Anagnosti
 *
 */
public class SelectState extends State implements Serializable{

	public void mousePressed(MouseEvent e) {
		GraphicEditor graphicEditor = View.get().getGraphicEditor();
		
		graphicEditor.getPaintApp().startDrag = new Point(e.getX(), e.getY());
		graphicEditor.getPaintApp().endDrag = graphicEditor.getPaintApp().startDrag;
		graphicEditor.setSelectColor(Color.LIGHT_GRAY);
		
		graphicEditor.getSelected().clear();
	}

	public void mouseReleased(MouseEvent e) {
		GraphicEditor graphicEditor = View.get().getGraphicEditor();
		
		Point start = graphicEditor.getPaintApp().startDrag;
		Point end = graphicEditor.getPaintApp().endDrag;
		View.get().getActionManager().getCopy().setSelectStart(start);
		View.get().getActionManager().getCopy().setSelectEnd(end);
		
		graphicEditor.getPaintApp().startDrag = null;
		graphicEditor.getPaintApp().endDrag = null;

		graphicEditor.getPaintApp().paint(null);
		for (Element element : graphicEditor.getEv().getMainElement().getPaint()) {
			if(element.isSelected(start, end))
				graphicEditor.getSelected().add(element);
		}
		
		graphicEditor.getEv().getMainElement().update();

	}

	public void mouseDragged(MouseEvent e) {
		View.get().getGraphicEditor().getPaintApp().endDrag = new Point(e.getX(), e.getY());
		View.get().getGraphicEditor().getEv().getPaintApp().endDrag = new Point(e.getX(), e.getY());
	}

}