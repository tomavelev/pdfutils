package com.programtom.pdfutils;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFAddingView extends JPanel {

	public PDFAddingView() {
		setLayout(new BorderLayout());

		JButton b = new JButton();
		b.setText("Add Files");
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser f = new JFileChooser();
				f.setMultiSelectionEnabled(true);
				int showOpenDialog = f.showOpenDialog(PDFAddingView.this);
				if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File[] selectedFiles = f.getSelectedFiles();

					Document document = new Document();
					try {
						PdfWriter.getInstance(document, new FileOutputStream("myppppdf.pdf"));

						document.open();
//						Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//						Chunk chunk = new Chunk("Hello World", font);
//						document.add(chunk);
						java.nio.file.Path path;
						for (File file : selectedFiles) {
						 path =file.toPath();
						 
						 Image img = Image.getInstance(path.toAbsolutePath().toString());
						 
						 int indentation = 0;
						//whatever
						Image image = img;

						float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
						               - document.rightMargin() - indentation) / image.getWidth()) * 100;

						image.scalePercent(scaler);
						 document.add(image);

						}
						
						
					

						document.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}
			
			
		});
		add(b,BorderLayout.CENTER);
	}
}
