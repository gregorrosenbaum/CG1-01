package a1;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

//TODO: !!!!!!! SAVE-Funktion einbauen (mit Menü)!!!!!!

public class ImageSaver {

	public static void main(String[] args) {

		// unsere höhe und breite des Fensters
		final int WIDTH = 640;
		final int HEIGHT = 480;

		final JFrame myFrame = new JFrame("Image Saver");

		final ImageCanvas canvas = new ImageCanvas(WIDTH, HEIGHT);

		myFrame.add(canvas);

		myFrame.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent e) {
				// Hier passiert nichts, muss für den Listener aber überschrieben werden
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// Hier passiert nichts, muss für den Listener aber überschrieben werden
			}

			@Override
			public void componentResized(ComponentEvent e) {
				canvas.setWidth(myFrame.getWidth());
				canvas.setHeight(myFrame.getHeight());
				canvas.repaint();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// Hier passiert nichts, muss für den Listener aber überschrieben werden
			}
		});

		myFrame.setSize(WIDTH, HEIGHT);
		myFrame.setVisible(true);

	}
}
