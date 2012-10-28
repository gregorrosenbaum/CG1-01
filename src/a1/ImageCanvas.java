package a1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageCanvas extends Canvas {

	private static final long serialVersionUID = 5555522598959749695L;

	private BufferedImage img;
	private int width = 500;
	private int height = 500;

	public void paint(final Graphics g) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		WritableRaster raster = img.getRaster();
		ColorModel model = img.getColorModel();

		for (int x = 0; x < height && x < width; x++) {
			raster.setDataElements(x, x, model.getDataElements(Color.red.getRGB(), null));
		}

		g.drawImage(img, 0, 0, null);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
