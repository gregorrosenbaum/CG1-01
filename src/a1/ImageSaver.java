package a1;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//TODO: !!!!!!! SAVE-Funktion einbauen (mit Menü)!!!!!!

public class ImageSaver {
	
	public ImageSaver(){
		try {
	    // retrieve image
	    BufferedImage bi = ImageCanvas.getImg();
	    File outputfile = new File("saved.png");
	    ImageIO.write(bi, "png", outputfile);
	} catch (IOException e) {
	    // Kann nicht gespeichert werden
		System.out.println("Bild konnte nicht gespeichert werden");
	}
	}

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
		
		JMenuBar menubar = new JMenuBar();
		myFrame.setJMenuBar(menubar);
	

		JMenu datei = new JMenu("Datei");
		menubar.add(datei);
		JMenuItem dateispeichern = new JMenuItem("Datei speichern");
		datei.add(dateispeichern);
	
		dateispeichern.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent e) { 
				//wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				myFrame.repaint();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen
				
			}

			public void mousePressed(MouseEvent e) {
				//wird nicht genutzt, aber wird benötigt um den MouseListener zu erstellen
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
					
			}});	
		


	}
}
