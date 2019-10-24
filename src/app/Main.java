package app;

import GUI_Elements.ChooseWorkspace;
import MVC.Model;
import MVC.View;
/**
 * 
 * Main klasa za GeRuDok aplikaciju. Inicijalizuje se <code>Model</code> i poziva se <code>ViewModel</code>, ujedno se i sam 
 * <code>ViewModel</code> inicijalizuje.
 * 
 * @author Anagnosti
 *
 */
public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		
		View.get().initModel(model);
	}

}
