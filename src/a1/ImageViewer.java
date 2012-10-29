package a1;

import java.awt.Graphics;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.event.MenuKeyListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//Subklasse von JComponent, damit sie relativ leicht �berall eingebunden werden kann
public class ImageViewer extends JComponent  {

	// //!!!!TODO: JMenuBar mit Option "Bild laden" hinzuf�gen (loadImage() benutzen) !!!!!!

	private static final long serialVersionUID = 1L;

	// Variablen des ImageViewers //
	// Der Beh�lter f�r unser Bild
	protected BufferedImage img;
	// Dialog-Fenster zum ausw�hlen einer Datei
	protected final JFileChooser fileDialog;
	// Filter f�r erlaubte Bildformate im fileDialog
	// // TODO: Bildformate zum FILTER hinzuf�gen
	protected final static FileNameExtensionFilter FILTER = new FileNameExtensionFilter("Images",
			"jpg", "gif", "png", "bmp", "tif", "ami", "apx", "bmp", "brk", "bw", "cal", "cbm", "cbr","cbz", "cpt", "cur", "dds", "dng", "exr", "fif", "fpx");

	// Variablen unseres Testprogramms //
	protected final JFrame frame;

	public ImageViewer(final JFrame frame) {
		this.frame = frame;
		fileDialog = new JFileChooser();
		fileDialog.setFileFilter(FILTER);
	}

	public void loadImage() {
		if (fileDialog.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			// Wenn ein Bild ausgew�hlt wird
			try {
				img = ImageIO.read(fileDialog.getSelectedFile());
			} catch (IOException e) {
				// falls es einen Fehler beim Laden gibt, wird der Dialog einfach neu angezeigt
				// //TODO: kann man das eleganter machen? Vielleicht vorher eine Fehlermeldung (Popup)?
				loadImage();
			}
		} else {
			// Wenn kein Bild ausgew�hlt wird
			// // TODO: Was passiert wenn kein Bild ausgew�hlt wird?
		}
	}

	// �berschreibt die paint-Methode von Component, so dass das Bild gezeichnet wird
	@Override
	public void paint(final Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	// liefert die H�he unseres Bildes oder 0, wenn es nicht existiert
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
		
	
		bildLaden.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				viewer.loadImage();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		myFrame.setSize(viewer.getImageWidth(), viewer.getImageHeight());
		myFrame.repaint();
		
	
		
		
	}
}