package com.github.neonblue2.myzip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class MyZip {
	private JButton okButton;
	private InputPanel ip;
	private CompressionPanel cp;
	private OutputPanel oup;
	private LevelPanel lp;
	private OptionsPanel opp;
	
	public static void main(String[] args) {
		new MyZip();
	}
	
	public MyZip() {
		okButton = new JButton("OK");
		okButton.addActionListener(new ButtonListener());
		
		ip = new InputPanel();
		oup = new OutputPanel();
		cp = new CompressionPanel(oup);
		lp = new LevelPanel();
		opp = new OptionsPanel();
		
		JFrame win = new JFrame("MyZip");
		win.setSize(400, 534);
		win.setResizable(false);
		win.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(ip);
		panel.add(cp);
		panel.add(oup);
		panel.add(lp);
		panel.add(opp);
		panel.add(okButton);
		win.add(panel);
		
		win.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == okButton) {
            	String compressionType = cp.getCompressionType();
            	String appPath = "/Applications/MyZip";
            	String dirPath = "dirPath=`dirname \"" + ip.getInputPath() + "\"`";
            	String input = "input=`basename \"" + ip.getInputPath() + "\"`";
            	String cd = "cd \"$dirPath\"";
            	String setUp = dirPath + "\n" + input + "\n\n" + cd + "\n";
            	String cmd = "NOTHING TO SEE HERE";
            	if (compressionType.equals("zip")) {
            		cmd = appPath + "/alt-zip -r -" + lp.getLevel() + " \"" + oup.getOutputPath()
            				+ "\".zip \"$input\"";
            		if (opp.getEncryption()) {
            			cmd = appPath + "/alt-zip -er -" + lp.getLevel() + " \"" + oup.getOutputPath()
                				+ "\".zip \"$input\"";
            		}
            	} else if (compressionType.equals("p7zip")) {
            		cmd = appPath + "/7za a -tzip -mx" + lp.getLevel() + " \"" + oup.getOutputPath()
    				+ "\".zip \"$input\"";
            	} else {
            		String tarBin = "alt-tar";
            		if (opp.getBsdTar()) {
            			tarBin = "alt-bsdtar";
            		}
            		String tar = appPath + "/" + tarBin + " -v -cf \"" + oup.getOutputPath() + "\".tar \"$input\"";
            		if (compressionType.equals("bzip2")) {
	            		cmd = tar + "\n" + appPath + "/alt-bzip2 -v -v -" + lp.getLevel() + " \""
	            				+ oup.getOutputPath() + "\".tar";
	            	} else if (compressionType.equals("pbzip2")) {
	            		cmd = tar + "\n" + appPath + "/pbzip2 -v -" + lp.getLevel() + " \""
	            				+ oup.getOutputPath() + "\".tar";
	            	} else if (compressionType.equals("gzip")) {
	            		cmd = tar + "\n" + appPath + "/alt-gzip -v -" + lp.getLevel() + " \""
	            				+ oup.getOutputPath() + "\".tar";
	            	} else if (compressionType.equals("pigz")) {
	            		cmd = tar + "\n" + appPath + "/pigz -v -" + lp.getLevel() + " \""
	            				+ oup.getOutputPath() + "\".tar";
	            	} else {
	            		if (compressionType.equals("p7bzip2")) {
	            			cmd = tar + "\n" + appPath + "/7za a -tbzip2 -mx" + lp.getLevel() + " \""
	            				+ oup.getOutputPath() + "\".tar.bz2" + " \"" + oup.getOutputPath() + "\".tar";
	            		} else if (compressionType.equals("p7gzip")) {
	            			cmd = tar + "\n" + appPath + "/7za a -tgzip -mx" + lp.getLevel() + " \""
	            				+ oup.getOutputPath() + "\".tar.gz" + " \"" + oup.getOutputPath() + "\".tar";
	            		}
	            		cmd = cmd + "\nrm \"" + oup.getOutputPath() + "\".tar";
	            	}
            	}
            	try {
        			FileWriter fstream = new FileWriter("/Users/jamesmadley/out.sh");
        			BufferedWriter out = new BufferedWriter(fstream);
        			out.write(setUp + "\n" + cmd + "\n\nprintf '\\a'");
        			out.close();
        		} catch (IOException e) {}
            	System.exit(0);
            }
        }
    }
}
