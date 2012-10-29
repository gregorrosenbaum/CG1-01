package a1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageCanvas extends Canvas {

	private static final long serialVersionUID = 5555522598959749695L;

	protected BufferedImage img;
	protected int width;
	protected int height;
	protected Color color;

	public ImageCanvas(int width, int height) {
		this(width, height, Color.red);
	}
	
	public ImageCanvas (int width, int height, Color color){
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public void paint(final Graphics g) {
		// erzeugt ein neues BufferedImage mit dem Farbtyp INT RGB
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < height && x < width; x++) {
			// setzt einen Punkt (Pixel) des Rasters mit den Koordinaten x,x auf die angegebene Farbe
			img.getRaster().setDataElements(x, x, img.getColorModel().getDataElements(color.getRGB(), null));
		}

		g.drawImage(img, 0, 0, null);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	// TODO: im ImageSaver einen Men�punkt implementieren, mit dem man die Farbe wechseln kann
	public void setColor(final Color color) {
		this.color = color;
	}

	public BufferedImage getImage() {
		return img;
	}


}

