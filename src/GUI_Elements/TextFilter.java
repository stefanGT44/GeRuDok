package GUI_Elements;

import java.io.File;

import javax.swing.filechooser.FileFilter;
/**
 * 
 * Koristi se kao file filter kada se browse-uje lokacija u tekst editoru.
 * 
 * @GUI_Elements.TextEditor
 * 
 * @author Anagnosti
 *
 */
public class TextFilter extends FileFilter{

	@Override
	public boolean accept(File arg0) {
		if (arg0.getAbsolutePath().endsWith(".txt") || arg0.getAbsolutePath().endsWith(".rtf")
				|| arg0.isDirectory())
			return true;
		return false;
	}

	@Override
	public String getDescription() {
		return ".txt or .rtf files";
	}

}
