package GUI_Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import MVC.View;
import Workspace.Slot;

public class ElementPopupChooser extends JDialog{
	
	private BufferedImage image, text, video, sound, imageBW, textBW, soundBW, videoBW;
	private ImageIcon imageICO, textICO, videoICO, soundICO, imageBWICO, textBWICO, soundBWICO, videoBWICO;
	private Slot slot;
	
	public ElementPopupChooser()
	{
		super(View.get());
		this.setTitle("Choose Element Type");
		this.setModal(true);
		this.setSize(450, 450);
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(2, 2));
		try {
			image = ImageIO.read(new File("src/Actions/images/imageIcon.png"));
			imageBW = ImageIO.read(new File("src/Actions/images/imageIcon-BlackWhite.png"));
			
			text = ImageIO.read(new File("src/Actions/images/textIcon.png"));
			textBW = ImageIO.read(new File("src/Actions/images/textIcon-BlackWhite.png"));
			
			video = ImageIO.read(new File("src/Actions/images/videoIcon.png"));
			videoBW = ImageIO.read(new File("src/Actions/images/videoIcon-BlackWhite.png"));
			
			sound = ImageIO.read(new File("src/Actions/images/soundIcon.png"));
			soundBW = ImageIO.read(new File("src/Actions/images/soundIcon-BlackWhite.png"));
			
			imageICO = new ImageIcon(image);
			textICO = new ImageIcon(text);
			videoICO = new ImageIcon(video);
			soundICO = new ImageIcon(sound);
			
			imageBWICO = new ImageIcon(imageBW);
			textBWICO = new ImageIcon(textBW);
			videoBWICO = new ImageIcon(videoBW);
			soundBWICO = new ImageIcon(soundBW);
			
			
			JLabel picLabel = new JLabel(imageBWICO);
			picLabel.addMouseListener(View.get().getActionManager().getHoverAction());
			panel.add(picLabel);
			
			JLabel picLabel1 = new JLabel(textBWICO);
			picLabel1.addMouseListener(View.get().getActionManager().getHoverAction());
			panel.add(picLabel1);
			
			JLabel picLabel2 = new JLabel(soundBWICO);
			picLabel2.addMouseListener(View.get().getActionManager().getHoverAction());
			panel.add(picLabel2);
			
			JLabel picLabel3 = new JLabel(videoBWICO);
			picLabel3.addMouseListener(View.get().getActionManager().getHoverAction());
			panel.add(picLabel3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
	
	}
	
	public void changePic(JLabel label)
	{
		if(label.getIcon() == imageICO)
			label.setIcon(imageBWICO);
		else
			if(label.getIcon() == imageBWICO)
				label.setIcon(imageICO);
			else
				if(label.getIcon() == textICO)
					label.setIcon(textBWICO);
				else
					if(label.getIcon() == textBWICO)
						label.setIcon(textICO);
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public ImageIcon getImageICO() {
		return imageICO;
	}

	public ImageIcon getTextICO() {
		return textICO;
	}
	
	

	
	
}
