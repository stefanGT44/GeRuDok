package Actions;

import java.awt.Point;
import java.awt.event.ActionEvent;

import DataView.ElementView;
import MVC.View;
import Workspace.Element;
/**
 * 
 * Klasa <code>Copy</code> sluzi za stavljanje elemenata koji se nalaze u Select ArrayList-i i u Copy ArrayList-u.
 * 
 * 
 * @see Actions.Copy
 * 
 * @author Anagnosti
 *
 */
public class Copy extends AbstractActionManager {
/**
 * Pocetnu tacku koju dobijemo kada se klikne Select. Kombinacijom tacaka <code>selectStart</code> i <code>selectEnd</code> se 
 * dobije prostor za kopiranje.
 *
 */
	private Point selectStart = new Point(0, 0);
	
/**
 * Krajnja tacka dobijena potom prevlacenja misem. Kombinacijom tacaka <code>selectStart</code> i <code>selectEnd</code> se 
 * dobije prostor za kopiranje.
 */
	private Point selectEnd = new Point(0, 0);
	
	public Copy() {
		putValue(SMALL_ICON, loadIcon("images/copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy action");
	}

/**
 * 
 * Prvo se izbrisu elementi iz liste, nakon cega se smeste nova tacka <code>selectStart</code> i <code>selectEnd</code> i
 * u listu elemenata se stavi sve sto je selektovano trenutno.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {		
		View.get().getGraphicEditor().getCopy().clear();
		View.get().getGraphicEditor().setSelectStart(selectStart);
		View.get().getGraphicEditor().setSelectEnd(selectEnd);
		
		for(Element el : View.get().getGraphicEditor().getSelected())
		{
			View.get().getGraphicEditor().getCopy().add(el);
		}

	}

	public Point getSelectStart() {
		return selectStart;
	}

	public void setSelectStart(Point selectStart) {
		this.selectStart = selectStart;
	}

	public Point getSelectEnd() {
		return selectEnd;
	}

	public void setSelectEnd(Point selectEnd) {
		this.selectEnd = selectEnd;
	}
	
	

}
