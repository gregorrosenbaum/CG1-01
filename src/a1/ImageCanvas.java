package a1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 * A wrapper that contains a {@link BufferedImage} which is manipulated not by {@code Graphics} but
 * by accessing the pixels in the raster.
 * 
 * @see WritableRaster
 * @see ColorModel
 * @see BufferedImage
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */

public class ImageCanvas extends Canvas {

	private static final long serialVersionUID = 5555522598959749695L;

	protected BufferedImage img;
	protected int width;
	protected int height;
	protected Color color;

	/**
	 * Creates the ImageCanvas with the specified width and height. The default color will be set to
	 * {@code red}.
	 * 
	 * @param width
	 *            the width of the image.
	 * @param height
	 *            the height of the image.
	 */
	public ImageCanvas(int width, int height) {
		this(width, height, Color.red);
	}

	/**
	 * Creates the ImageCanvas with the specified width and height and the specified color to draw.
	 * 
	 * @param width
	 *            the width of the image.
	 * @param height
	 *            the height of the image.
	 * @param color
	 *            the color to draw with.
	 */
	public ImageCanvas(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public void paint(final Graphics g) {
		// erzeugt ein neues BufferedImage mit dem Farbtyp INT RGB
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < height && x < width; x++) {
			// setzt einen Punkt des Rasters mit den Koordinaten x,x auf die angegebene Farbe
			img.getRaster().setDataElements(x, x, img.getColorModel().getDataElements(color.getRGB(), null));
		}

		g.drawImage(img, 0, 0, null);
	}

	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the image. Redraws the {@link ImageCanvas} for the changes to show.
	 * 
	 * @param width
	 *            the width of the image.
	 */
	public void setWidth(final int width) {
		this.width = width;
		repaint();
	}

	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the image. Redraws the {@link ImageCanvas} for the changes to show.
	 * 
	 * @param height
	 *            the height of the image.
	 */
	public void setHeight(final int height) {
		this.height = height;
		repaint();
	}

	/**
	 * Gets the color of the image.
	 * 
	 * @return the {@link Color} of the image.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the image
	 * 
	 * @param color
	 *            the {@link Color} of the image.
	 */
	public void setColor(final Color color) {
		this.color = color;
	}

	/**
	 * Gets the BufferedImage in the {@link ImageCanvas}.
	 * 
	 * @return the {@link BufferedImage} in the {@link ImageCanvas}.
	 */
	public BufferedImage getImage() {
		return img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + height;
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageCanvas other = (ImageCanvas) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (height != other.height)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImageCanvas (" + width + "x" + height + ")";
	}

}
