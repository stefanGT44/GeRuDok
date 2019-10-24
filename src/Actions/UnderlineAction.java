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
 * 
 * Selektovani deo teksta biva podvucen. Ukoliko je prethodno bio podvucen, podvucenost se negira i tekst se vrati u normalu.
 * 
 * @GUI_Elements.TextEditor
 * 
 * 
 * @author Anagnosti
 *
 */
public class UnderlineAction extends AbstractActionManager{

	public UnderlineAction(){
		//putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		       // KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/underline.png"));
		
		putValue(NAME, "Underline");
		putValue(SHORT_DESCRIPTION, "Underline text");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		StyledDocument doc = (StyledDocument) View.get().getTextEditor().getTextPane().getDocument();
		Style logicalStyle = doc.getLogicalStyle(View.get().getTextEditor().getTextPane().getSelectionStart());
		Element element = doc.getCharacterElement(View.get().getTextEditor().getTextPane().getSelectionStart());
		AttributeSet as = element.getAttributes();
		
		
		SimpleAttributeSet sas = new SimpleAttributeSet();
		
		boolean isUnderlined = StyleConstants.isUnderline(as);
		if (!isUnderlined){
			StyleConstants.setUnderline(sas, true);
		} else {
			StyleConstants.setUnderline(sas, false);
		}
		View.get().getTextEditor().getTextPane().getStyledDocument().setCharacterAttributes(View.get().getTextEditor().getTextPane().getSelectionStart(),
				View.get().getTextEditor().getTextPane().getSelectionEnd()-View.get().getTextEditor().getTextPane().getSelectionStart(), sas, false);
	}
	
}
