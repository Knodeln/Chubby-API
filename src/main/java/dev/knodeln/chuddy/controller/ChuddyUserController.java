package dev.knodeln.chuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.knodeln.chuddy.Exceptions.UserAlreadyExistsException;
import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ChuddyUserController {


    public static void addUser(ChuddyUser newUser) throws UserAlreadyExistsException {
        ChuddyDataHandler.addUser(newUser);

    }

    public static void deleteUser(ChuddyUser userToBeDeleted) {
        ChuddyDataHandler.getAllUsers().removeIf(user -> user.getEmail().equals(userToBeDeleted.getEmail()));

    }

}
