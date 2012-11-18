package com.github.neonblue2.myzip;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutWindow extends JFrame {
	public AboutWindow() {
		//setResizable(false);
		setLayout(new BorderLayout());
		
		final JLabel text = new JLabel("MyZip");
		add(text, BorderLayout.CENTER);
		
		final JButton closeButton = new JButton("Close");
		add(closeButton, BorderLayout.SOUTH);
	}
}
