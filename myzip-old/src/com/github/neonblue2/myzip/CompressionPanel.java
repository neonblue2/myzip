package com.github.neonblue2.myzip;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CompressionPanel extends JPanel {
	private JRadioButton zipRadio;
	private JRadioButton bzip2Radio;
	private JRadioButton pbzip2Radio;
	private JRadioButton gzipRadio;
	private JRadioButton pigzRadio;
	private JRadioButton p7zipRadio;
	private JRadioButton p7bzip2Radio;
	private JRadioButton p7gzipRadio;
	private String compressionType;
	private OutputPanel oup;
	
	public CompressionPanel(OutputPanel oup) {
		setMaximumSize(new Dimension(400, 534));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		this.oup = oup;
		compressionType = "NONE";
		
		ButtonGroup radioGroup = new ButtonGroup();
		
		zipRadio = new JRadioButton("ZIP");
		bzip2Radio = new JRadioButton("bzip2");
		pbzip2Radio = new JRadioButton("pbzip2");
		gzipRadio = new JRadioButton("gzip");
		pigzRadio = new JRadioButton("pigz");
		p7zipRadio = new JRadioButton("7-zip (ZIP)");
		p7bzip2Radio = new JRadioButton("7-zip (bzip2)");
		p7gzipRadio = new JRadioButton("7-zip (gzip)");
		
		zipRadio.addActionListener(new ButtonListener());
		bzip2Radio.addActionListener(new ButtonListener());
		pbzip2Radio.addActionListener(new ButtonListener());
		gzipRadio.addActionListener(new ButtonListener());
		pigzRadio.addActionListener(new ButtonListener());
		p7zipRadio.addActionListener(new ButtonListener());
		p7bzip2Radio.addActionListener(new ButtonListener());
		p7gzipRadio.addActionListener(new ButtonListener());
		
		radioGroup.add(zipRadio);
		radioGroup.add(bzip2Radio);
		radioGroup.add(pbzip2Radio);
		radioGroup.add(gzipRadio);
		radioGroup.add(pigzRadio);
		radioGroup.add(p7zipRadio);
		radioGroup.add(p7bzip2Radio);
		radioGroup.add(p7gzipRadio);
		
		add(zipRadio);
		add(bzip2Radio);
		add(pbzip2Radio);
		add(gzipRadio);
		add(pigzRadio);
		add(p7zipRadio);
		add(p7bzip2Radio);
		add(p7gzipRadio);
	}
	
	private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == zipRadio) {
            	compressionType = "zip";
            	oup.setExtension("zip");
            } else if (a.getSource() == bzip2Radio) {
            	compressionType = "bzip2";
            	oup.setExtension("tar.bz2");
            } else if (a.getSource() == pbzip2Radio) {
            	compressionType = "pbzip2";
            	oup.setExtension("tar.bz2");
            } else if (a.getSource() == gzipRadio) {
            	compressionType = "gzip";
            	oup.setExtension("tar.gz");
            } else if (a.getSource() == pigzRadio) {
            	compressionType = "pigz";
            	oup.setExtension("tar.gz");
            } else if (a.getSource() == p7zipRadio) {
            	compressionType = "p7zip";
            	oup.setExtension("zip");
            } else if (a.getSource() == p7bzip2Radio) {
            	compressionType = "p7bzip2";
            	oup.setExtension("tar.bz2");
            } else if (a.getSource() == p7gzipRadio) {
            	compressionType = "p7gzip";
            	oup.setExtension("tar.gz");
            }
        }
    }
	
	public String getCompressionType() {
		return compressionType;
	}
}
