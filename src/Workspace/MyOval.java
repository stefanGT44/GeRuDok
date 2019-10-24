package Workspace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import MVC.View;
/**
 * 
 * Predstavlja graficki tip elelemnta koji prikazuje crveni krug, ukoliko nije selectovan, siv ukoliko jeste. Moze da se
 * iscrtava cut copy paste brise. 
 * 
 * 
 * @see Workspace.Element
 * @see Workspace.MainElement
 * @see Actions.SelectAction
 * @see ActionsCut
 * @see Actions.Copy
 * @see Actions.Paste
 * 
 * @author Anagnosti
 *
 */
public class MyOval extends Element {
	private Ellipse2D elip2d;

	public MyOval() {
		this.type = "image";
		this.name = "Circle";
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
			elip2d = new Ellipse2D.Float(start.x-(width/2), start.y-(height/2), width, height);
			((Graphics2D) g).draw(elip2d);
		} catch (Exception e) {
		}

	}

	@Override
	public boolean isSelected(Point start, Point end) {
		if (contains(this.start, start, end) && contains(this.end, start, end)) {
			lineColor = Color.LIGHT_GRAY;
			return true;
		} else {
			lineColor = Color.RED;
			return false;
		}
	}

	public Ellipse2D getElip2d() {
		return elip2d;
	}

	
	@Override
	public Element cloneMe()
	{
		MyOval ov = new MyOval();
		ov.lineColor = Color.RED;
		ov.setStart(start);
		ov.setEnd(end);
		
		return ov;
	}
}
