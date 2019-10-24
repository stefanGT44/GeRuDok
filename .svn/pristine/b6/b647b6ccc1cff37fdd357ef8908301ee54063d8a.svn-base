package Actions;

import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 * 
 * Klasa koja sluzi za ucitavanje slika ili drugim recima ikonica akcija koje su smestene na toolbar-u. U slucaju da 
 * ikonica nije mogla da se pronadje, to jest putanja ka ikonici je invalidna, ispisace se poruka upozorenja 
 * "Resource not found: " + ime fajla.
 * 
 * 
 * 
 * @author Anagnosti
 *
 */
public abstract class AbstractActionManager extends AbstractAction{
	
	public Icon loadIcon(String fileName){
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;
		
		
		if (imageURL != null) {
	        icon = new ImageIcon(imageURL);
	    } else {                                     
	        System.err.println("Resource not found: " + fileName);
	    }

		return icon;
	}
	
}