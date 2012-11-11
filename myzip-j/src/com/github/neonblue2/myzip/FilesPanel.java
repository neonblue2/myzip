package com.github.neonblue2.myzip;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FilesPanel extends JPanel {
	private JTextField outputTextField;
	private JList fileList;
	
	public FilesPanel() {
		setLayout(new BorderLayout());
		
		final JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		final JLabel outputLabel = new JLabel("Output:");
		outputTextField = new JTextField();
		outputPanel.add(outputLabel, BorderLayout.WEST);
		outputPanel.add(outputTextField, BorderLayout.CENTER);
		
		String[] s = {"File 1", "File 2", "File 3"};
		fileList = new JList(s);
		final JScrollPane fileListScrollPane = new JScrollPane(fileList);
		
		add(outputPanel, BorderLayout.NORTH);
		add(fileListScrollPane, BorderLayout.CENTER);
		
	}
}
