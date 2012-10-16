package a1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends JComponent {

	private static final long serialVersionUID = 1L;
	protected BufferedImage img = null;
	protected final static FileNameExtensionFilter FILTER = new FileNameExtensionFilter(
			"Images", "jpg", "gif", "png");
	protected JFileChooser fc;
	protected final JFrame frame;

	public ImageViewer(JFrame frame) {
		this.frame = frame;
		fc = new JFileChooser();
		fc.setFileFilter(FILTER);
	}

	public void loadImage() {
		if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			try {
				img = ImageIO.read(fc.getSelectedFile());
			} catch (IOException e) {
				loadImage();
			}
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	private int getImageHeight() {
		if (img == null) {
			return 0;
		} else {
			return img.getHeight();
		}
	}

	private int getImageWidth() {
		if (img == null) {
			return 0;
		} else {
			return img.getWidth();
		}
	}

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Image Viewer");
		ImageViewer viewer = new ImageViewer(myFrame);

		viewer.loadImage();
		myFrame.add(viewer);

		myFrame.setSize(viewer.getImageWidth(), viewer.getImageHeight());
		myFrame.setVisible(true);
	}
}
