/* 
 * MyZip - A GUI for various command line compression programs.
 * Copyright (C) 2012  James Madley <jdmadley@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.github.neonblue2.myzip;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		quitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		fileMenu.add(quitMenuItem);
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem prefsMenuItem = new JMenuItem("Preferences");
		editMenu.add(prefsMenuItem);
		menuBar.add(editMenu);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem helpMenuItem = new JMenuItem("About");
		helpMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				new AboutWindow().setVisible(true);
			}
		});
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
