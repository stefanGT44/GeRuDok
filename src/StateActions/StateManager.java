package StateActions;

import java.io.Serializable;

import DataView.ElementView;
import Workspace.MainElement;
import Workspace.Slot;
/**
 * 
 * Sadrzi instance svakog State-a kao i current state koji predstavlja trenutno stanje na main elementu. 
 * 
 * rectanglestate,circlestate,selectstate,pastestate,mainelement
 * 
 * @see StateActions.RectangleState
 * @see StateActions.CircleState
 * @see StateActions.SelectState
 * @see StateActions.PasteState
 * @see Workspace.MainElement
 *  
 * @author Anagnosti
 *
 */
public class StateManager implements Serializable{

	private State currentState;
	private RectangleState rectangleState;
	private CircleState circleState;
	private SelectState selectState;
	private PasteState pasteState;

	public StateManager() {
		
		rectangleState = new RectangleState();
		circleState = new CircleState();
		selectState = new SelectState();
		pasteState = new PasteState();
		
		currentState = rectangleState;
	}
	
	public void setRectangleState(){ currentState = rectangleState;}
	public void setCircleState(){ currentState = circleState;}
	public void setSelectState(){ currentState = selectState;}
	public void setPasteState(){ currentState = pasteState;}
	
	public State getCurrentState() {
		return currentState;
	}
	

}