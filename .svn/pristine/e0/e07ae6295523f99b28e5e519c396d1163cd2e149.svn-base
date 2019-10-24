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
 * Namesta selektovani deo teksta u <code>TextEditor</code> u <code>SubScript</code> i takodje se to automatski podesi i namesti
 * u tekstu u <code>ElementView</code>. Ukoliko je prethodno bio izvrsen SubScript, pojava se negira i tekst se vrati u normalu.
 * 
 * @see GUI_Elements.TextEditor
 * 
 * 
 * @author Anagnosti
 *
 */
public class SubAction extends AbstractActionManager{
	
	public SubAction(){
	//	putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		  //      KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/sub.png"));
		
		putValue(NAME, "Subscript");
		putValue(SHORT_DESCRIPTION, "subscript text");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StyledDocument doc = (StyledDocument) View.get().getTextEditor().getTextPane().getDocument();
		Style logicalStyle = doc.getLogicalStyle(View.get().getTextEditor().getTextPane().getSelectionStart());
		Element element = doc.getCharacterElement(View.get().getTextEditor().getTextPane().getSelectionStart());
		AttributeSet as = element.getAttributes();
		
		
		SimpleAttributeSet sas = new SimpleAttributeSet();
		
		boolean isSub = StyleConstants.isSubscript(as);
		if (!isSub){
			StyleConstants.setSubscript(sas, true);
		} else {
			StyleConstants.setSubscript(sas, false);
		}
		View.get().getTextEditor().getTextPane().getStyledDocument().setCharacterAttributes(View.get().getTextEditor().getTextPane().getSelectionStart(),
				View.get().getTextEditor().getTextPane().getSelectionEnd()-View.get().getTextEditor().getTextPane().getSelectionStart(), sas, false);
	}

}
