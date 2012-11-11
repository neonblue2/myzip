package com.github.neonblue2.myzip;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class OptionsPanel extends JPanel {
	private JCheckBox zipEncryption;
	private JCheckBox bsdTar;
	private boolean useEncryption;
	private boolean useBsdTar;
	
	public OptionsPanel() {
		setMaximumSize(new Dimension(400, 534));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		
		zipEncryption = new JCheckBox("Enable ZIP encryption");
		bsdTar = new JCheckBox("Use bsdtar");
		useEncryption = false;
		useBsdTar = false;
		
		zipEncryption.addItemListener(new ButtonListener());
		bsdTar.addItemListener(new ButtonListener());
		
		add(zipEncryption);
		add(bsdTar);
	}
	
	private class ButtonListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == zipEncryption) {
            	useEncryption = !useEncryption;
            } else if (e.getSource() == bsdTar) {
            	useBsdTar = !useBsdTar;
            }
        }
    }
	
	public boolean getEncryption() {
		return useEncryption;
	}
	
	public boolean getBsdTar() {
		return useBsdTar;
	}
}
