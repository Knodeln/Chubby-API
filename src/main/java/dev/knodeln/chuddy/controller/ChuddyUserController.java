package dev.knodeln.chuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static List<ChuddyUser> allUsers;

    public static void addUser(ChuddyUser newUser){
        boolean userExists = false;
        for (ChuddyUser user : allUsers) {
            if (user.getEmail().equals(newUser.getEmail())) {
                userExists = true;
                break;
            }
        }
        if (!userExists) {
            allUsers.add(newUser);
        }


    }

    public static void deleteUser(ChuddyUser userToBeDeleted) {
        allUsers.removeIf(user -> user.getEmail().equals(userToBeDeleted.getEmail()));

    }
    public static void addFriend(ChuddyUser user1, ChuddyUser user2) {
        List<ChuddyUser> friendsForUser1 = user1.getFriends();
        friendsForUser1.add(user2);
        user1.setFriends(friendsForUser1);

        List<ChuddyUser> friendForUser2 = user2.getFriends();
        friendForUser2.add(user1);
        user1.setFriends(friendForUser2);
        //Should add a conversation between users when adding friends


    }

}
