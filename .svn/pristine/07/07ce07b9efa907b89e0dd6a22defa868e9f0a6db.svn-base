package Actions;

import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import GUI_Elements.ShareWith;
import MVC.View;
import Workspace.Document;
/**
 * 
 * Akcija koja pokrece share-ovanje selektovanog dokumenta. Pojavljuje se pop-up window u kome se pojavljuje lista projekata
 * koji ne sadrze taj dokument. Izborom jednog od navedenih projekata ce se selektovan dokument share-ovati u izabrani projekat.
 *
 * 
 * 
 * @author Anagnosti
 *
 */
public class ShareAction extends AbstractActionManager {

	public ShareAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/share.png"));

		putValue(NAME, "Share Document");
		putValue(SHORT_DESCRIPTION, "Share Document");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = View.get().getModel().getWorkspaceTree().getLastSelectedPathComponent();
		if (obj instanceof Document)
			new ShareWith();
	}

}
