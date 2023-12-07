package dev.knodeln.chuddy;

import dev.knodeln.chuddy.controller.ChuddyUserController;
import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.UserService;
import dev.knodeln.chuddy.view.TestFrame;


import javax.swing.*;



public class ChuddyApplication extends JFrame {

	public static void main(String[] args) {
		ChuddyDataHandler.startUp();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestFrame().setVisible(true);
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
 