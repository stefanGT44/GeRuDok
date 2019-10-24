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
 * Akcija koja je posvecena pretvaranju selektovanog teksta u Italic.
 *
 * 
 * @see GUI_Elements.TextEditor
 * 
 * @author Anagnosti
 *
 */
public class ItalicAction extends AbstractActionManager{

	public ItalicAction() {
		//putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		       // KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/italic.png"));
		
		putValue(NAME, "Italic");
		putValue(SHORT_DESCRIPTION, "Italic text");
		
	}

/**
 * 
 * Proverava se da li je trenutno selektovan tekst Italic. U slucaju da jeste, on ce postati normalan, to jest nece vise
 * biti Italic. U slucaju da nije, bice postavljen kao Italic.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		StyledDocument doc = (StyledDocument) View.get().getTextEditor().getTextPane().getDocument();
		Style logicalStyle = doc.getLogicalStyle(View.get().getTextEditor().getTextPane().getSelectionStart());
		Element element = doc.getCharacterElement(View.get().getTextEditor().getTextPane().getSelectionStart());
		AttributeSet as = element.getAttributes();
		
		
		SimpleAttributeSet sas = new SimpleAttributeSet();
		
		boolean isItalic = StyleConstants.isItalic(as);
		if (!isItalic){
			StyleConstants.setItalic(sas, true);
		} else {
			StyleConstants.setItalic(sas, false);
		}
		View.get().getTextEditor().getTextPane().getStyledDocument().setCharacterAttributes(View.get().getTextEditor().getTextPane().getSelectionStart(),
				View.get().getTextEditor().getTextPane().getSelectionEnd()-View.get().getTextEditor().getTextPane().getSelectionStart(), sas, false);
	}

}
