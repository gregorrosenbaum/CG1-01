package a1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

//Subklasse von JComponent, damit sie relativ leicht überall eingebunden werden kann
public class ImageViewer extends JComponent {

	// //!!!!TODO: JMenuBar mit Option "Bild laden" hinzufügen (loadImage() benutzen) !!!!!!

	private static final long serialVersionUID = 1L;

	// Variablen des ImageViewers //
	// Der Behälter für unser Bild
	protected BufferedImage img;
	// Dialog-Fenster zum auswählen einer Datei
	protected final JFileChooser fileDialog;
	// Filter für erlaubte Bildformate im fileDialog
	// // TODO: Bildformate zum FILTER hinzufügen
	protected final static FileNameExtensionFilter FILTER = new FileNameExtensionFilter("Images", "jpg", "gif", "png");

	// Variablen unseres Testprogramms //
	protected final JFrame frame;

	public ImageViewer(final JFrame frame) {
		this.frame = frame;
		fileDialog = new JFileChooser();
		fileDialog.setFileFilter(FILTER);
	}

	public void loadImage() {
		if (fileDialog.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			// Wenn ein Bild ausgewählt wird
			try {
				img = ImageIO.read(fileDialog.getSelectedFile());
			} catch (IOException e) {
				// falls es einen Fehler beim Laden gibt, wird der Dialog einfach neu angezeigt
				// //TODO: kann man das eleganter machen? Vielleicht vorher eine Fehlermeldung (Popup)?
				loadImage();
			}
		} else {
			// Wenn kein Bild ausgewählt wird
			// // TODO: Was passiert wenn kein Bild ausgewählt wird?
		}
	}

	// überschreibt die paint-Methode von Component, so dass das Bild gezeichnet wird
	@Override
	public void paint(final Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	// liefert die Höhe unseres Bildes oder 0, wenn es nicht existiert
	private int getImageHeight() {
		if (img == null) {
			return 0;
		} else {
			return img.getHeight();
		}
	}

	// liefert die Breite unseres Bildes oder 0, wenn es nicht existiert
	private int getImageWidth() {
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

		
		JMenu neuesBild = new JMenu("Neues Bild");
		menubar.add(neuesBild);
		JMenuItem bildLaden = new JMenuItem("Bild laden");
		neuesBild.add(bildLaden);
		
	
		
		
	}
}