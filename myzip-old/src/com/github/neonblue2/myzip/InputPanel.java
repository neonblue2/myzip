package com.github.neonblue2.myzip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;

public class InputPanel extends JPanel {
	private JTextField inputField;
	private JButton inputButton;
	
	public InputPanel() {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setMaximumSize(new Dimension(400, 534));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel inputLabel = new JLabel("File Input");
		inputLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		inputField = new JTextField();
		inputButton = new JButton("Choose...");
		
		inputButton.addActionListener(new ButtonListener());
		
		inputField.setMaximumSize(new Dimension(400, 22));
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(inputField);
		panel.add(inputButton);
		
		add(inputLabel);
		add(panel);
	}
	
	public String getInputPath() {
		return inputField.getText();
	}
	
	private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == inputButton) {
            	JFileChooser fC = new JFileChooser();
            	int returnVal = fC.showOpenDialog(null);
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
            		File file = fC.getSelectedFile();
                	inputField.setText(file.getAbsolutePath());
            	}
            }
        }
    }
}
