package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
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
 * Akcija posvecena boldovanju selektovanog teksta u tekstuoalnom editoru.
 * 
 * @see GUI_Elements.TextEditor
 * 
 * @author Anagnosti
 *
 */
public class BoldAction extends AbstractActionManager{
	
	public BoldAction(){
		//putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		      //  KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/bold1.png"));
		
		putValue(NAME, "Bold");
		putValue(SHORT_DESCRIPTION, "Bold text");
		
	}
	
/**
 * 
 * Kada se selektuje zeljen tekst, pritiskom na dugme koje poziva metodu <code>actionPerformed</code> ce se selektovan tekst
 * boldovati.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		StyledDocument doc = (StyledDocument) View.get().getTextEditor().getTextPane().getDocument();
		Style logicalStyle = doc.getLogicalStyle(View.get().getTextEditor().getTextPane().getSelectionStart());
		Element element = doc.getCharacterElement(View.get().getTextEditor().getTextPane().getSelectionStart());
		AttributeSet as = element.getAttributes();
		
		SimpleAttributeSet sas = new SimpleAttributeSet();
		
		boolean isBold = StyleConstants.isBold(as);
		if (!isBold){
			StyleConstants.setBold(sas, true);
		} else {
			StyleConstants.setBold(sas, false);
		}
		View.get().getTextEditor().getTextPane().getStyledDocument().setCharacterAttributes(View.get().getTextEditor().getTextPane().getSelectionStart(),
				View.get().getTextEditor().getTextPane().getSelectionEnd()-View.get().getTextEditor().getTextPane().getSelectionStart(), sas, false);
	}

}
