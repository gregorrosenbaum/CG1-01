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

/**
 * A little application that uses {@link ImageCanvas} and {@link ImageIO#write()} to create an image
 * and save it wherever the user decides
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */

public class ImageSaver {

	// uses ImageIO so save the BufferedImage to the path
	// the suffix is added without any checks if it is already specified in path
	// you could do some regex but that seemed like a bit overkill for a simple application
	public static void saveImageToPng(final BufferedImage img, final String path) throws IOException {
		ImageIO.write(img, "png", new File(path + ".png"));
	}

	// same as above, with a file instead of a path
	public static void saveImageToPng(final BufferedImage img, final File file) throws IOException {
		saveImageToPng(img, file.getPath());
	}

	public static void main(String[] args) {

		// unsere hoehe und breite des Fensters
		final int WIDTH = 640;
		final int HEIGHT = 480;

		final JFrame myFrame = new JFrame("Image Saver");

		final ImageCanvas canvas = new ImageCanvas(WIDTH, HEIGHT);

		myFrame.add(canvas);

		myFrame.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent e) {
				// Hier passiert nichts, muss fuer den Listener aber ueberschrieben werden
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// Hier passiert nichts, muss fuer den Listener aber ueberschrieben werden
			}

			@Override
			public void componentResized(ComponentEvent e) {
				canvas.setWidth(myFrame.getWidth());
				canvas.setHeight(myFrame.getHeight());
				canvas.repaint();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// Hier passiert nichts, muss fuer den Listener aber ueberschrieben werden
			}
		});

		myFrame.setSize(WIDTH, HEIGHT);
		myFrame.setVisible(true);

		final JMenuBar menuBar = new JMenuBar();
		myFrame.setJMenuBar(menuBar);

		final JMenu file = new JMenu("Datei");
		menuBar.add(file);
		final JMenuItem saveFile = new JMenuItem("Datei speichern");
		file.add(saveFile);

		final JFileChooser fileDialog = new JFileChooser();

		saveFile.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// wird nicht genutzt, aber wird benoetigt um den MouseListener zu erstellen
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// wird nicht genutzt, aber wird benoetigt um den MouseListener zu erstellen
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// wird nicht genutzt, aber wird benoetigt um den MouseListener zu erstellen
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// wird nicht genutzt, aber wird benoetigt um den MouseListener zu erstellen
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (fileDialog.showSaveDialog(myFrame) == JFileChooser.APPROVE_OPTION) {
					try {
						saveImageToPng(canvas.getImage(), fileDialog.getSelectedFile());
					} catch (IOException exception) {
						JOptionPane.showMessageDialog(myFrame, "Fehler bei Dateiauswahl. Datei nicht gespeichert.");
					}
				}

			}
		});

	}
}
