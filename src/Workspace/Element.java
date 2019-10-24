package Workspace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Observable;
import javax.swing.tree.TreeNode;
/**
 * 
 * Kompozitna struktura. Predstavlja glavnu, roditeljsku klasu za mainelement, myrectangle, myoval. MainElement moze da
 * sadrzi veci broj elemenata. Ima svoj tip, sliku ili zvuk, ime ukoliko se odnosi na myrectangle ili myoval koriste se 
 * parametri linecolor, point start i point end  i visina i sirina. Ukoliko je selectovan, linecolor mu je boje lightgray.
 * 
 * 
 * @see Workspace.MyRectangle
 * @see Workspace.MyOval
 * @see Workspace.MainElement
 * 
 * @author Anagnosti
 *
 */
public abstract class Element extends Observable implements TreeNode, Serializable{

	protected String type;
	protected String name;

	protected Color lineColor = Color.RED;
	protected Point start, end;
	protected int width = 50, height = 50;

	public Element() {
		// TODO: implement
	}

	public void draw(Graphics g){
	}
	
	public void drawDragged(Graphics g){
	}
	
	public boolean isSelected(Point start, Point end){
		return false;
	}
	
	public boolean contains(Point p, Point start, Point end) {
		if (p.getX() > start.getX() && p.getX() < end.getX() && p.getY() > start.getY() && p.getY() < end.getY())
			return true;

		if (p.getX() < start.getX() && p.getX() > end.getX() && p.getY() > start.getY() && p.getY() < end.getY())
			return true;

		if (p.getX() > start.getX() && p.getX() < end.getX() && p.getY() < start.getY() && p.getY() > end.getY())
			return true;

		if (p.getX() < start.getX() && p.getX() > end.getX() && p.getY() < start.getY() && p.getY() > end.getY())
			return true;

		return false;
	}
	
	public Element cloneMe()
	{
		return null; 
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Enumeration children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public String toString() {
		return this.name;
	}
	

}