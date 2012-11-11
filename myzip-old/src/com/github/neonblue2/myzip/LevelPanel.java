package com.github.neonblue2.myzip;

import java.awt.*;
import javax.swing.*;

public class LevelPanel extends JPanel {
	private JComboBox compressionLevels;
	
	public LevelPanel() {
		setMaximumSize(new Dimension(400, 534));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel compressionLabel = new JLabel("Level of compression");
		compressionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		Integer[] levels = new Integer[9]; 
		for (int i = 0; i < 9; i++) {
			levels[i] = new Integer(i+1);
		}
		
		compressionLevels = new JComboBox(levels);
		compressionLevels.setMaximumSize(new Dimension(400, 25));
		compressionLevels.setAlignmentX(Component.LEFT_ALIGNMENT);
		compressionLevels.setSelectedIndex(8);
		
		add(compressionLabel);
		add(compressionLevels);
	}
	
	public Object getLevel() {
		return compressionLevels.getSelectedItem();
	}
}
