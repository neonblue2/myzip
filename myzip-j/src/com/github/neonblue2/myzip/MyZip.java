package com.github.neonblue2.myzip;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyZip {

	private static JFrame window;
	
	public static void main(String[] args) {
		window = new JFrame("MyZip");
		init();
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void init() {
		initMenuBar();
		initPanels();
	}
	
	private static void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem quitMenuItem = new JMenuItem("Quit");
		fileMenu.add(quitMenuItem);
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem prefsMenuItem = new JMenuItem("Preferences");
		editMenu.add(prefsMenuItem);
		menuBar.add(editMenu);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem helpMenuItem = new JMenuItem("About");
		helpMenu.add(helpMenuItem);
		menuBar.add(helpMenu);
		
		window.setJMenuBar(menuBar);
	}
	
	private static void initPanels() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new OptionsPanel(), BorderLayout.WEST);
		mainPanel.add(new FilesPanel(), BorderLayout.CENTER);
		window.add(mainPanel);
	}

}
