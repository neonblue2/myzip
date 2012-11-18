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
