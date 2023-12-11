package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.Exceptions.UserNotFoundException;
import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrentUserController {
    public static void login(String email, String password) throws UserNotFoundException{

            UserService.manageLogin(email, password);
    }

}
