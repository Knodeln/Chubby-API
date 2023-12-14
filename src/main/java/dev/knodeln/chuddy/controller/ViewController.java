package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.view.*;

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
    public static void setForumView() {
        new ChatForumGUI().setVisible(true);
    }
    public static void setAddFriendsView(){
        new AddFriendsGUI().setVisible(true);
    }
    public static void setMyFriendsView() {
        new MyFriendsGUI().setVisible(true);
    }
    public static void setConversationFrameView() {
        new ConversationFrame().setVisible(true);
    }
}
