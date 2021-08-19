package com.programtom.pdfutils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7479788923094003549L;
	private MainFrame() {
		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		try{
////		URL input = ClassLoader.getSystemResource("todo.png");
////		BufferedImage read = ImageIO.read(input);
////		setIconImage(read);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		setTitle(I18n.s("todo") +" v. " + App.version);
		pack();
		setSize(750, 600);
		setCenter(this);
	}
	public static final MainFrame INSTANCE = new MainFrame();
	public static void start() {
		INSTANCE.add(new PDFAddingView(), BorderLayout.CENTER);
		INSTANCE.setVisible(true);
	}

	public static void setCenter(Window w){
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - w.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - w.getHeight()) / 2);
	    w.setLocation(x, y);
	}
}
