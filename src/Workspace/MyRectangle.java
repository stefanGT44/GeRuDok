package Workspace;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import MVC.View;
/**
 * 
 * Predstavlja graficki tip elelemnta koji prikazuje crveni pravougaonik, ukoliko nije selectovan, siv ukoliko jeste. Moze da se
 * iscrtava cut copy paste brise. 
 * 
 * 
 * @see Workspace.Element
 * @see Workspace.MainElement
 * @see Actions.SelectAction
 * @see Actions.Cut
 * @see Actions.Copy
 * @see Actions.Paste
 * 
 * @author Anagnosti
 *
 */
public class MyRectangle extends Element{

	private Rectangle2D.Float rect;
	
	public MyRectangle() {
		this.type = "image";
		this.name = "Rectangle";
	}

	public void makeObject(Point startDrag, Point endDrag) {
		lineColor = View.get().getGraphicEditor().getSelectColor();

		start = startDrag;
		end = endDrag;
	}

	@Override
	public void draw(Graphics g) {
		try {
			g.setColor(lineColor);
			rect = new Rectangle2D.Float(start.x-(width/2), start.y-(height/2), width, height);
			((Graphics2D) g).draw(rect);
		} catch (Exception e) {
		}
	}

	@Override
	public void drawDragged(Graphics g) {
		try {
			g.setColor(lineColor);
			g.drawRect(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(start.x - end.x),
					Math.abs(start.y - end.y));
		} catch (Exception e) {
		}
	}

	@Override
	public boolean isSelected(Point start, Point end) {
		if (contains(this.start, start, end) && contains(this.end, start, end))
			return true;

		return false;
	}
	
	@Override
	public Element cloneMe()
	{
		MyRectangle rec = new MyRectangle();
		rec.lineColor = Color.RED;
		rec.setStart(start);
		rec.setEnd(end);
		
		return rec;
	}
}
