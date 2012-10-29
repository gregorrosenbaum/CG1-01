package a1;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ImageSaver {

	public static void saveImage(BufferedImage img, String path) throws IOException {
		saveImageToPNG(img, new File(path));
	}

	public static void saveImageToPNG(BufferedImage img, File file) throws IOException {
			ImageIO.write(img, "png", file);
	}

	public static void main(String[] args) {

		// unsere h�he und breite des Fensters
		final int WIDTH = 640;
		final int HEIGHT = 480;

		final JFrame myFrame = new JFrame("Image Saver");

		final ImageCanvas canvas = new ImageCanvas(WIDTH, HEIGHT);

		myFrame.add(canvas);

		myFrame.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent e) {
				// Hier passiert nichts, muss f�r den Listener aber
				// �berschrieben werden
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// Hier passiert nichts, muss f�r den Listener aber
				// �berschrieben werden
			}

			@Override
			public void componentResized(ComponentEvent e) {
				canvas.setWidth(myFrame.getWidth());
				canvas.setHeight(myFrame.getHeight());
				canvas.repaint();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// Hier passiert nichts, muss f�r den Listener aber
				// �berschrieben werden
			}
		});

		myFrame.setSize(WIDTH, HEIGHT);
		myFrame.setVisible(true);

		JMenuBar menubar = new JMenuBar();
		myFrame.setJMenuBar(menubar);

		JMenu datei = new JMenu("Datei");
		menubar.add(datei);
		JMenuItem dateispeichern = new JMenuItem("Datei speichern");
		datei.add(dateispeichern);

		final JFileChooser fileDialog = new JFileChooser();

		dateispeichern.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// wird nicht genutzt, aber wird ben�tigt um den MouseListener
				// zu erstellen

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// wird nicht genutzt, aber wird ben�tigt um den MouseListener
				// zu erstellen

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// wird nicht genutzt, aber wird ben�tigt um den MouseListener
				// zu erstellen

			}

			public void mousePressed(MouseEvent e) {
				// wird nicht genutzt, aber wird ben�tigt um den MouseListener
				// zu erstellen

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (fileDialog.showSaveDialog(myFrame) == JFileChooser.APPROVE_OPTION) {
					try {
						saveImageToPNG(canvas.getImage(), fileDialog.getSelectedFile());
					} catch (IOException exception) {
						JOptionPane.showMessageDialog(myFrame, "Fehler bei Dateiauswahl");
					}
				}

			}
		});

	}
}
