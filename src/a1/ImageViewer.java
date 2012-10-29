package a1;

import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * A Component that allows quick and simple embedding of user selected images.
 * <p>
 * After creating a new ImageViewer, you should load an image using {@link #loadImage()}
 * 
 * 
 * @author Johann Hofmann
 * @author Gregor Rosenbaum
 * @author Anton Krebs
 */

// Subklasse von JComponent, damit sie relativ leicht überall eingebunden werden kann
public class ImageViewer extends JComponent {

	private static final long serialVersionUID = 1L;

	// Variablen des ImageViewers //
	// Der Behälter für unser Bild
	protected BufferedImage img;
	// Dialog-Fenster zum auswählen einer Datei
	protected final JFileChooser fileDialog;
	// Filter für erlaubte Bildformate im fileDialog
	protected final static FileNameExtensionFilter FILTER = new FileNameExtensionFilter("Images", "jpg", "gif", "png", "bmp", "tif");

	// Variablen unseres Testprogramms //
	protected final Window frame;

	/**
	 * Creates an ImageViewer that belongs to the given {@link Window}.
	 */

	public ImageViewer(final Window frame) {
		this.frame = frame;
		fileDialog = new JFileChooser();
		fileDialog.setFileFilter(FILTER);
	}

	/**
	 * Causes the ImageViewer to show a {@link JFileChooser} and replace the image with the selected File.
	 * <p>
	 * If the File cannot be found, a {@link JOptionPane}-warning is shown.
	 * <p>
	 * A {@link FileNameExtensionFilter} is used to filter the selection of shown files in the dialog.
	 * 
	 * If the user cancels the first filedialog or manages to select a non-image file, the image will be empty.
	 * 
	 */

	public void loadImage() {
		if (fileDialog.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			// Wenn ein Bild ausgewählt wird
			try {
				img = ImageIO.read(fileDialog.getSelectedFile());
			} catch (IOException e) {
				// falls es einen Fehler beim Laden gibt, wird eine Fehlermeldung angezeigt
				JOptionPane.showMessageDialog(frame, "Fehler bei Dateiauswahl");
				loadImage();
			}
		} else {
			// Wenn Cancel gedrückt wird passiert einfach nichts.
		}
	}

	// überschreibt die paint-Methode von Component, so dass das Bild gezeichnet wird
	@Override
	public void paint(final Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	/**
	 * 
	 * Returns the height of the {@link BufferedImage}. Returns 0 if it does not exist (yet).
	 * 
	 * @return the height of the image or 0 if the image does not exist.
	 */

	// liefert die Höhe unseres Bildes oder 0, wenn es nicht existiert
	public int getImageHeight() {
		if (img == null) {
			return 0;
		} else {
			return img.getHeight();
		}
	}

	/**
	 * 
	 * Returns the width of the {@link BufferedImage}. Returns 0 if it does not exist (yet).
	 * 
	 * @return the width of the image or 0 if the image does not exist.
	 */

	// liefert die Breite unseres Bildes oder 0, wenn es nicht existiert
	public int getImageWidth() {
		if (img == null) {
			return 0;
		} else {
			return img.getWidth();
		}
	}

	public static void main(String[] args) {
		final JFrame myFrame = new JFrame("Image Viewer");
		final ImageViewer viewer = new ImageViewer(myFrame);

		JMenuBar menubar = new JMenuBar();
		myFrame.setJMenuBar(menubar);

		viewer.loadImage();
		myFrame.add(viewer);

		myFrame.setSize(viewer.getImageWidth(), viewer.getImageHeight());
		myFrame.setVisible(true);

		JMenu newImageMenu = new JMenu("Neues Bild");
		menubar.add(newImageMenu);
		JMenuItem loadImageButton = new JMenuItem("Bild laden");
		newImageMenu.add(loadImageButton);

		loadImageButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				viewer.loadImage();
				myFrame.setSize(viewer.getImageWidth(), viewer.getImageHeight());
				myFrame.repaint();
			}
		});

	}
}