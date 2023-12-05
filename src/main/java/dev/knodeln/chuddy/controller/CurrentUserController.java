package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrentUserController {

    public ChuddyUser currentUser;

    @Autowired
    private UserService userService;


    public void setCurrentUser(String email, String password) {

    }

    public void setCurrentUser(ChuddyUser currentUser) {
        this.currentUser = currentUser;
    }

}
