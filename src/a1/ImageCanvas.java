package a1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class ImageCanvas extends JComponent{

	private static final long serialVersionUID = 5555522598959749695L;
	
	protected final BufferedImage img;
	
	public ImageCanvas(BufferedImage img){
		this.img = img;
	}
	
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
		
}
