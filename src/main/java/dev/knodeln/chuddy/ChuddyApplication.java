package dev.knodeln.chuddy;

import dev.knodeln.chuddy.model.*;
import dev.knodeln.chuddy.view.LoginGUI;


import javax.swing.*;



public class ChuddyApplication extends JFrame {

	public static void main(String[] args) {
		ChuddyDataHandler.startUp();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginGUI().setVisible(true);
			}
		});

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				ChuddyDataHandler.shutDown();
			}
		}));
	}
}
 