package com.github.neonblue2.myzip;

import java.awt.BorderLayout;

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
	private JComboBox<String> compressionComboBox;
	private JRadioButton gnutarRadioButton;
	private JRadioButton bsdtarRadioButton;
	private JSpinner levelSpinner;
	private JCheckBox zipEncryptCheckBox;
	private JComboBox<String> destinationComboBox;
	
	public OptionsPanel() {
		setLayout(new BorderLayout());
		
		// The JPanel that holds everything above the "Compress" button
		// at the bottom.
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		
		// Compression type option.
		final JLabel compressionLabel = new JLabel("Compression");
		topPanel.add(compressionLabel);
		compressionComboBox = new JComboBox<String>(getCompressionOpts());
		topPanel.add(compressionComboBox);
		
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
		topPanel.add(tarPanel);
		
		// Compression level.
		final JLabel levelLabel = new JLabel("Level:");
		SpinnerNumberModel levelSpinnerNumberModel = new SpinnerNumberModel(9, 1, 9, 1);
		levelSpinner = new JSpinner(levelSpinnerNumberModel);
		JPanel levelPanel = new JPanel();
		levelPanel.setLayout(new BoxLayout(levelPanel, BoxLayout.X_AXIS));
		levelPanel.add(levelLabel);
		levelPanel.add(levelSpinner);
		topPanel.add(levelPanel);
		
		// Extra options.
		final JLabel optionsLabel = new JLabel("Options");
		zipEncryptCheckBox = new JCheckBox("ZIP Encryption");
		topPanel.add(optionsLabel);
		topPanel.add(zipEncryptCheckBox);
		
		// Destination.
		final JLabel destinationLabel = new JLabel("Destination");
		destinationComboBox = new JComboBox<String>(getDestinations());
		topPanel.add(destinationLabel);
		topPanel.add(destinationComboBox);
		
		// Compress button at the bottom of this JPanel.
		compressButton = new JButton("Compress");
		
		add(topPanel, BorderLayout.CENTER);
		add(compressButton, BorderLayout.SOUTH);
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
