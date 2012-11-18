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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OptionsPanel extends JPanel {
	private JButton compressButton;
	private JComboBox compressionComboBox;
	private JRadioButton gnutarRadioButton;
	private JRadioButton bsdtarRadioButton;
	private JSpinner levelSpinner;
	private JCheckBox zipEncryptCheckBox;
	private JComboBox destinationComboBox;
	
	public OptionsPanel() {
		setLayout(new BorderLayout());
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints globalConstraints = new GridBagConstraints();
		globalConstraints.gridx = 0;
		globalConstraints.anchor = GridBagConstraints.NORTHWEST;
		globalConstraints.fill = GridBagConstraints.HORIZONTAL;
		globalConstraints.weighty = 0.0;
		
		// Compression type option.
		final JLabel compressionLabel = new JLabel("Output");
		compressionComboBox = new JComboBox(getCompressionOpts());
		compressionComboBox.setMaximumSize(compressionComboBox.getMinimumSize());
		middlePanel.add(compressionLabel, globalConstraints);
		middlePanel.add(compressionComboBox, globalConstraints);
		
		// Tar options.
		gnutarRadioButton = new JRadioButton("GNU Tar");
		bsdtarRadioButton = new JRadioButton("BSD Tar");
		ButtonGroup tarButtonGroup = new ButtonGroup();
		tarButtonGroup.add(gnutarRadioButton);
		tarButtonGroup.add(bsdtarRadioButton);
		JPanel tarPanel = new JPanel();
		tarPanel.setLayout(new BoxLayout(tarPanel, BoxLayout.X_AXIS));
		tarPanel.add(gnutarRadioButton);
		tarPanel.add(bsdtarRadioButton);
		middlePanel.add(tarPanel, globalConstraints);
		
		// Compression level.
		final JLabel levelLabel = new JLabel("Level:");
		SpinnerNumberModel levelSpinnerNumberModel = new SpinnerNumberModel(9, 1, 9, 1);
		levelSpinner = new JSpinner(levelSpinnerNumberModel);
		levelSpinner.setMaximumSize(levelSpinner.getMinimumSize());
		JPanel levelPanel = new JPanel();
		levelPanel.setLayout(new BoxLayout(levelPanel, BoxLayout.X_AXIS));
		levelPanel.add(levelLabel);
		levelPanel.add(levelSpinner);
		middlePanel.add(levelPanel, globalConstraints);
		
		// Extra options.
		final JLabel optionsLabel = new JLabel("Options");
		zipEncryptCheckBox = new JCheckBox("ZIP Encryption");
		middlePanel.add(optionsLabel, globalConstraints);
		middlePanel.add(zipEncryptCheckBox, globalConstraints);
		
		// Destination.
		final JLabel destinationLabel = new JLabel("Destination");
		destinationComboBox = new JComboBox(getDestinations());
		destinationComboBox.setMaximumSize(destinationComboBox.getMinimumSize());
		middlePanel.add(destinationLabel, globalConstraints);
		middlePanel.add(destinationComboBox, globalConstraints);
		
		globalConstraints.weighty = 1.0;
		globalConstraints.fill = GridBagConstraints.VERTICAL;
		middlePanel.add(javax.swing.Box.createVerticalGlue(), globalConstraints);
		
		// Compress button at the bottom of this JPanel.
		compressButton = new JButton("Compress");
		
		globalConstraints.weighty = 0.0;
		globalConstraints.fill = GridBagConstraints.HORIZONTAL;
		middlePanel.add(compressButton, globalConstraints);
		add(middlePanel, BorderLayout.CENTER);
		
		add(Box.createRigidArea(new Dimension(0,2)), BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(0,2)), BorderLayout.SOUTH);
		add(Box.createRigidArea(new Dimension(2,0)), BorderLayout.WEST);
		add(Box.createRigidArea(new Dimension(2,0)), BorderLayout.EAST);
	}
	
	/**
	 * Return the compression options available. Used to fill the
	 * compression combo box.
	 * 
	 * @return A string array of the different compression options
	 * 	available.
	 */
	private String[] getCompressionOpts() {
		String[] s = {"ZIP", "bzip2", "pbzip2", "gzip", "pigz",
				"7-zip (ZIP)", "7-zip (bzip2)", "7-zip (gzip)"};
		return s;
	}
	
	private String[] getDestinations() {
		String[] s = {"Here", "There", "Everywhere"};
		return s;
	}
}
