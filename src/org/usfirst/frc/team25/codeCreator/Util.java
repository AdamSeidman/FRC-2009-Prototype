package org.usfirst.frc.team25.codeCreator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Util {

	public static double getSpeed() {
		final JSlider js = new JSlider(0, 100, 50);
		final JLabel jsInfo = new JLabel("50%", SwingConstants.CENTER);
		js.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jsInfo.setText(Integer.toString(js.getValue()) + "%");
			}
		});
		JPanel jsPane = new JPanel();
		jsPane.setLayout(new BorderLayout());
		jsPane.add(js, BorderLayout.CENTER);
		jsPane.add(jsInfo, BorderLayout.SOUTH);
		JOptionPane.showMessageDialog(null, jsPane, "...at what speed?",
				JOptionPane.PLAIN_MESSAGE);
		return ((double) js.getValue()) / 100;
	}

	public static File getFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setApproveButtonMnemonic(KeyEvent.VK_ENTER);
		jfc.setDialogTitle("Choose A File");
		jfc.setBackground(Color.WHITE);
		File raiderDesktop = new File("C:\\Users\\raiderrobotix\\Desktop");
		if (raiderDesktop.exists())
			jfc.setCurrentDirectory(raiderDesktop);
		File ret;
		do {
			jfc.showOpenDialog(null);
			ret = jfc.getSelectedFile();
		} while (ret == null);
		return ret;
	}

}
