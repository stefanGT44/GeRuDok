package Actions;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

/**
 * 
 * Klasa <code>AboutAction</code> je akcija koja sluzi za prikaz website-a sa podacima tima 202.1. Klikom na opciju About 
 * pod menu item-om Help se otvara website prozor programiran u HTML-u u kom se mogu videti slike, kao i imena svakog clana
 * tima 202.1.
 * 
 * 
 * 
 * @author Anagnosti
 *
 */
public class AboutAction extends AbstractActionManager{

	public AboutAction()
	{
		putValue(SMALL_ICON, loadIcon("images/about.png"));
		putValue(NAME, "About GeRuDok");
		putValue(SHORT_DESCRIPTION, "About GeRuDok");
	}
	
/**
 * 
 * Kada se <code>actionPerformed</code> pokrene, otvara se website prozor u kom se mogu videti slike, kao i imena svakog 
 * clana tima 202.1. U slucaju da ne je link neodgovarajuc, ispisace se u konzoli "ne radi about link".
 * 
 * 
 * 
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
	        Desktop.getDesktop().browse(new URL("http://greenhatsgerudok-about.eu.pn/").toURI());
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        System.out.println("ne radi about link");
	    }
		
	}

}
