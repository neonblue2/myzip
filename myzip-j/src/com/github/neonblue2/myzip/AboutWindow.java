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
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutWindow extends JFrame {
	public AboutWindow() {
		setTitle("About MyZip");
		
		setMinimumSize(new Dimension(370, 396));
		setResizable(false);
		setLayout(new BorderLayout());
		
		final JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints globalConstraints = new GridBagConstraints();
		globalConstraints.gridx = 0;
		globalConstraints.anchor = GridBagConstraints.NORTH;
		globalConstraints.fill = GridBagConstraints.NONE;
		globalConstraints.weightx = 1.0;
		globalConstraints.weighty = 0.0;
		
		final JLabel iconLabel = new JLabel("ICON GOES HERE");
		infoPanel.add(iconLabel, globalConstraints);
		
		infoPanel.add(Box.createRigidArea(new Dimension(0,12)), globalConstraints);
		
		final JLabel titleLabel = new JLabel("MyZip");
		infoPanel.add(titleLabel, globalConstraints);
		
		infoPanel.add(Box.createRigidArea(new Dimension(0,12)), globalConstraints);
		
		final JLabel infoLabel = new JLabel("File compression frontend.");
		infoPanel.add(infoLabel, globalConstraints);
		
		infoPanel.add(Box.createRigidArea(new Dimension(0,12)), globalConstraints);
		
		final JLabel copyrightLabel = new JLabel("Copyright © 2012 James Madley");
		infoPanel.add(copyrightLabel, globalConstraints);
		
		infoPanel.add(Box.createRigidArea(new Dimension(0,12)), globalConstraints);
		
		final JLabel linkLabel = new JLabel("<HTML><FONT color=\"#0000ee\"><U>https://github.com/neonblue2/myzip</U></FONT></HTML>");
		linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		linkLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI("https://github.com/neonblue2/myzip"));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent event) {}
			
			@Override
			public void mousePressed(MouseEvent event) {}
			
			@Override
			public void mouseExited(MouseEvent event) {}
			
			@Override
			public void mouseEntered(MouseEvent event) {}
		});
		infoPanel.add(linkLabel, globalConstraints);
		
		globalConstraints.fill = GridBagConstraints.VERTICAL;
		globalConstraints.weighty = 1.0;
		infoPanel.add(Box.createVerticalGlue(), globalConstraints);
		
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		final JButton creditsButton = new JButton("Credits");
		buttonPanel.add(creditsButton);
		
		final JButton licenseButton = new JButton("License");
		buttonPanel.add(licenseButton);
		
		buttonPanel.add(Box.createHorizontalGlue());
		
		final JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				closeWindow();
			}
		});
		buttonPanel.add(closeButton);
		
		globalConstraints.fill = GridBagConstraints.HORIZONTAL;
		globalConstraints.weighty = 0.0;
		infoPanel.add(buttonPanel, globalConstraints);
		
		add(infoPanel, BorderLayout.CENTER);
		add(Box.createRigidArea(new Dimension(0,12)), BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(0,12)), BorderLayout.SOUTH);
		add(Box.createRigidArea(new Dimension(12,0)), BorderLayout.WEST);
		add(Box.createRigidArea(new Dimension(12,0)), BorderLayout.EAST);
	}
	
	private void closeWindow() {
		WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeEvent);
	}
}
