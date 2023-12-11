package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.view.LoginGUI;
import dev.knodeln.chuddy.view.ProfilePageGUI;
import dev.knodeln.chuddy.view.SignUp;

public class ViewController {
    public static void setLoginView() {
        new LoginGUI().setVisible(true);
    }

    public static void setProfilePageView() {
        new ProfilePageGUI().setVisible(true);

    }

    public static void setSignUpView() {
        new SignUp().setVisible(true);

    }
}
