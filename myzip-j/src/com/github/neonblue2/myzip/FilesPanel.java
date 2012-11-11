package com.github.neonblue2.myzip;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilesPanel extends JPanel {
	private JTextField outputTextField;
	
	public FilesPanel() {
		setLayout(new BorderLayout());
		
		final JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		final JLabel outputLabel = new JLabel("Output:");
		outputTextField = new JTextField();
		outputPanel.add(outputLabel, BorderLayout.WEST);
		outputPanel.add(outputTextField, BorderLayout.CENTER);
		
		add(outputPanel, BorderLayout.NORTH);
		
	}
}
