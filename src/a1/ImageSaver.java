package a1;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ImageSaver {

	protected final static int OFFSET_X = 15;
	protected final static int OFFSET_Y = 35;

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Image Saver");

		final BufferedImage img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		myFrame.addComponentListener(new ComponentListener() {
			public void componentResized(ComponentEvent evt) {
				drawLine(img, 500, 500);
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {}

			@Override
			public void componentMoved(ComponentEvent arg0) {}

			@Override
			public void componentShown(ComponentEvent arg0) {}
		});

		drawLine(img, 500, 500);

		myFrame.add(new ImageCanvas(img));

		myFrame.setSize(500 + 15, 500 + 35);
		myFrame.setVisible(true);

	}

	private static void drawLine(BufferedImage img, int width, int height) {
		for (int x = 0; x < width; x++) {
			img.setRGB(x, x, 0xFF00FF00);
		}
	}
}
