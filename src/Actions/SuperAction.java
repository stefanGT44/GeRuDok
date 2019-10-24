package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.sun.glass.events.KeyEvent;

import GUI_Elements.TextEditor;
import MVC.View;
/**
 * 
 * Namesta selektovani deo teksta u <code>TextEditor</code> u <code>SuperScript</code> i takodje se to automatski podesi i namesti
 * u tekstu u <code>ElementView</code>. Ukoliko je prethodno bio izvrsen SuperScript, pojava se negira i tekst se vrati u normalu.
 * 
 * @see GUI_Elements.TextEditor
 * 
 * @author Anagnosti
 *
 */
public class SuperAction extends AbstractActionManager{
	
	public SuperAction(){
		//putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		   //     KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/super.png"));
		
		putValue(NAME, "SuperScript");
		putValue(SHORT_DESCRIPTION, "Super script");
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		StyledDocument doc = (StyledDocument) View.get().getTextEditor().getTextPane().getDocument();
		Style logicalStyle = doc.getLogicalStyle(View.get().getTextEditor().getTextPane().getSelectionStart());
		Element element = doc.getCharacterElement(View.get().getTextEditor().getTextPane().getSelectionStart());
		AttributeSet as = element.getAttributes();
		
		
		SimpleAttributeSet sas = new SimpleAttributeSet();
		
		boolean isSuper = StyleConstants.isSuperscript(as);
		if (!isSuper){
			StyleConstants.setSuperscript(sas, true);
		} else {
			StyleConstants.setSuperscript(sas, false);
		}
		View.get().getTextEditor().getTextPane().getStyledDocument().setCharacterAttributes(View.get().getTextEditor().getTextPane().getSelectionStart(),
				View.get().getTextEditor().getTextPane().getSelectionEnd()-View.get().getTextEditor().getTextPane().getSelectionStart(), sas, false);
	}

}
