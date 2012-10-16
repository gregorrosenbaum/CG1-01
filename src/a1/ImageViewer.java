package a1;

import java.awt.Frame;
import java.awt.FileDialog;

public class ImageViewer {

	public static void main(String[] args) {
		Frame myFrame = new Frame("Image Viewer");
		FileDialog fd = new FileDialog(myFrame, "Select");
		myFrame.setSize(500, 500);
		myFrame.setVisible(true);
		fd.setVisible(true);
	}

}
