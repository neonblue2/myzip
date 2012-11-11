package com.github.neonblue2.myzip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class OutputPanel extends JPanel {
	private JTextField outputField;
	private JButton outputButton;
	private String path;
	private String extension;
	
	public OutputPanel() {
		setMaximumSize(new Dimension(400, 534));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel outputLabel = new JLabel("Save As...");
		outputLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		outputField = new JTextField();
		outputButton = new JButton("Choose...");
		
		outputButton.addActionListener(new ButtonListener());
		
		outputField.setMaximumSize(new Dimension(400, 22));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		path = "";
		extension = "";
		
		panel.add(outputField);
		panel.add(outputButton);
		
		add(outputLabel);
		add(panel);
	}
	
	public String getOutputPath() {
		return path;
	}
	
	public void setExtension(String ext) {
		extension = ext;
		outputField.setText(path + "." + extension);
	}
	
	private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == outputButton) {
            	JFileChooser fC = new JFileChooser();
            	int returnVal = fC.showSaveDialog(null);
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
            		File file = fC.getSelectedFile();
            		path = file.getAbsolutePath();
                	outputField.setText(path + "." + extension);
            	}
            }
        }
    }
}
