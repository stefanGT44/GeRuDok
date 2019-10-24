package GUI_Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import DataView.ElementView;
import MVC.View;
/**
 *
 * Klasa predstavlja tekstualni editor. postoji mogucnost manipulacije tekstom (font, velicina fonta, boja, bold, italic, 
 * underlined, subscript, superscript). Sav tekst se istovremeno prenosi na odgovarajuci elementview.
 * Postoji opcija cuvanja teksta na lokalnoj memoriji, kao i ucitavanje postojecih tekstualnih dokumenata. Podrzava 
 * format .txt i .rtf
 * 
 * 
 * @see DataView.ElementView
 * @see Actions.mouseAdapterRP
 * @see Actions.MouseMotionAdapter
 * @see Workspace.MainElement
 * 
 * @author Anagnosti
 *
 */
public class TextEditor extends JFrame {

	private JTextPane textPane;
	private JMenuBar menu;
	private JToolBar toolBar;
	private JPanel panel = new JPanel();
	private JComboBox comboBox = new JComboBox();
	private JComboBox fontSize = new JComboBox();
	private JColorChooser color = new JColorChooser();
	private JButton btn = new JButton();
	private Style style;
	private Color selectedColor;
	private ElementView elementView;
	private MouseAdapter mouseAdapter;
	private MouseMotionAdapter mouseMotionAdapter;
	private JScrollPane scrolPanel;

	public TextEditor() {
		this.setTitle("Text editor");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		panel.setLayout(new BorderLayout());

		textPane = new JTextPane();
		scrolPanel = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(scrolPanel, BorderLayout.CENTER);

		menu = new JMenuBar();
		toolBar = new JToolBar();
		toolBar.add(View.get().getActionManager().getBoldAction());
		toolBar.add(View.get().getActionManager().getItalicAction());
		toolBar.add(View.get().getActionManager().getUnderlineAction());
		toolBar.addSeparator();
		toolBar.add(new JLabel("Font: "));
		loadFont();
		toolBar.add(comboBox);
		toolBar.setFloatable(false);

		toolBar.add(Box.createHorizontalStrut(8));
		toolBar.add(new JLabel("Size: "));
		loadSizes();
		toolBar.add(fontSize);
		fontSize.setSelectedIndex(5);

		btn.setSize(70, 50);
		btn.setBackground(Color.black);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnSelectColorActionPerformed(e);
			}
		});
		// toolBar.addSeparator();
		toolBar.add(Box.createHorizontalStrut(8));
		toolBar.add(new JLabel("Color: "));
		toolBar.add(Box.createHorizontalStrut(5));
		toolBar.add(btn);
		toolBar.add(Box.createHorizontalStrut(5));
		toolBar.addSeparator();
		toolBar.add(View.get().getActionManager().getSupAction());
		toolBar.add(View.get().getActionManager().getSubAction());

		panel.add(toolBar, BorderLayout.NORTH);

		JMenu file = new JMenu("File");
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();

			}
		});
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		JMenuItem selectAll = new JMenuItem("Select all");
		selectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPane.selectAll();
			}
		});
		file.add(open);
		file.add(save);
		file.add(selectAll);
		file.addSeparator();
		file.add(close);
		menu.add(file);
		this.setJMenuBar(menu);

		this.add(panel);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				close();
				super.windowClosing(arg0);
			}

		});
		
		try {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image icon = kit.getImage("src/TreeConfig/images/txtEditor.png");
			setIconImage(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadFont() {
		GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = gEnv.getAvailableFontFamilyNames();
		ComboBoxModel model = new DefaultComboBoxModel(fontNames);
		comboBox.setModel(model);
		comboBox.setSelectedIndex(25);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fontSelected(e);
			}
		});
	}

	private void loadSizes() {
		int p = 8;
		for (int i = 1; i <= 13; i++) {
			fontSize.addItem(p);
			if (p < 12)
				p++;
			else
				p += 2;
		}
		fontSize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sizeSelected(e);
			}
		});
	}

	private void btnSelectColorActionPerformed(java.awt.event.ActionEvent evt) {
		Color jColor = selectedColor;
		if ((jColor = JColorChooser.showDialog(this, "Select color", jColor)) != null) {
			selectedColor = jColor;
			textPane.setForeground(selectedColor);
			btn.setBackground(selectedColor);
		}
	}

	private void fontSelected(java.awt.event.ActionEvent evt) {
		StyledDocument doc = (StyledDocument) elementView.getTextPane().getDocument();
		Style logicalStyle = doc.getLogicalStyle(elementView.getTextPane().getSelectionStart());
		Element element = doc.getCharacterElement(elementView.getTextPane().getSelectionStart());
		AttributeSet as = element.getAttributes();

		if (textPane.getCaretPosition() == 0) {
			textPane.setFont(new Font(comboBox.getSelectedItem().toString(), Font.PLAIN,
					Integer.parseInt(fontSize.getSelectedItem().toString())));
			return;

		}
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setFontFamily(sas, (String) comboBox.getSelectedItem());
		doc.setCharacterAttributes(textPane.getSelectionStart(),
				textPane.getSelectionEnd() + 1 - textPane.getSelectionStart(), sas, true);
	}

	private void sizeSelected(java.awt.event.ActionEvent evt) {
		String getSize = fontSize.getSelectedItem().toString();
		Font f = textPane.getFont();
		textPane.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(getSize)));
	}

	public JTextPane getTextPane() {
		return this.textPane;
	}

	private void open() {
		JFileChooser file = new JFileChooser();
		TextFilter filter = new TextFilter();
		file.setFileFilter(filter);
		String fileName = "";
		if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			fileName = file.getSelectedFile().getAbsolutePath();
			try {
				if (fileName.contains(".txt")) {
					Scanner s = new Scanner(new File(fileName));
					while (s.hasNextLine()) {
						textPane.setText(textPane.getText() + s.nextLine());
					}
					s.close();
					return;
				} else {
					RTFEditorKit rtf = new RTFEditorKit();
					try {
						FileInputStream fi = new FileInputStream(fileName);
						rtf.read(fi, textPane.getDocument(), 0);
						fi.close();
					} catch (Exception e) {

					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else
			return;
	}

	private void save() {
		JFileChooser file = new JFileChooser();
		TextFilter filter = new TextFilter();
		file.setFileFilter(filter);
		String fileName = "";
		if (file.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			fileName = file.getSelectedFile().getAbsolutePath();
			StyledDocument doc = (StyledDocument) textPane.getDocument();
			RTFEditorKit kit = new RTFEditorKit();
			BufferedOutputStream out;
			try {
				out = new BufferedOutputStream(new FileOutputStream(fileName));
				kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
				out.flush();
				out.close();
			} catch (Exception e) {
				System.out.println("Err:" + e.toString());
			}

		} else {
			return;
		}
	}

	public void setTextPane(JTextPane textPane) {

		try {
			this.textPane.setDocument(textPane.getDocument());
			fontSize.setSelectedIndex(elementView.getMainElement().getFontIndex());
			this.selectedColor = elementView.getMainElement().getsColor();
			this.textPane.setForeground(selectedColor);
			btn.setBackground(selectedColor);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}

	public ElementView getElementView() {
		return elementView;
	}

	public void setElementView(ElementView elementView) {
		this.elementView = elementView;
	}

	public void close() {
		elementView.getTextPane().setDocument(textPane.getDocument());
		elementView.getMainElement().setTxtDocument(textPane.getDocument());
		elementView.getMainElement().setFontIndex(fontSize.getSelectedIndex());
		elementView.getMainElement().setsColor(this.selectedColor);
		//elementView.getMainElement().setFont(textPane.getFont());
		dispose();

	}

}
