package a1;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

//TODO: !!!!!!! SAVE-Funktion einbauen (mit Menü)!!!!!!

public class ImageSaver {

	protected final static int OFFSET_X = 15;
	protected final static int OFFSET_Y = 35;

	public static void main(String[] args) {
		final JFrame myFrame = new JFrame("Image Saver");

		final ImageCanvas ic = new ImageCanvas();

		myFrame.add(ic);

		myFrame.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {
				ic.setWidth(myFrame.getWidth());
				ic.setHeight(myFrame.getHeight());
				ic.repaint();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		myFrame.setSize(500 + 15, 500 + 35);
		myFrame.setVisible(true);

	}
}
