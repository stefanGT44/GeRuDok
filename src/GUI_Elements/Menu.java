package GUI_Elements;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import MVC.View;
/**
 * 
 * Predstavlja MenuBar u gerudok aplikaciji koji se puni akcijama iz paketa akcije.
 * 
 * 
 * @see MVC.View
 * @see Actions.NewObjectAction
 * @see Actions.SwitchWorkspace
 * @see Actions.Import
 * @see Actions.AboutAction
 * 
 * @author Anagnosti
 *
 */
public class Menu extends JMenuBar{
	
	public Menu(){
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		fileMenu.add(View.get().getActionManager().getNewObjectAction());
		fileMenu.add(View.get().getActionManager().getImportAction());
		fileMenu.add(View.get().getActionManager().getSwitchWorkspace());
		
		fileMenu.addSeparator();
		fileMenu.add(View.get().getActionManager().getExitAction());
		
		this.add(fileMenu);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(View.get().getActionManager().getAboutAction());
		
		
		this.add(helpMenu);
	}

}