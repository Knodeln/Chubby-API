package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.Exceptions.UserNotFoundException;
import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrentUserController {
    public static void login(String email, String password) throws UserNotFoundException{
        UserService.manageLogin(email, password);
    }
    public static void logout() {
        ChuddyDataHandler.setUserLoggedIn(null);
    }
    public static void updateCurrentUserInformation(String name, String age, String description, String edProgramme, String year, String gender, String profilePicture) {
        UserService.updateUser(ChuddyDataHandler.getUserLoggedIn(), name, age, description, edProgramme, year, gender, profilePicture);
    }
    public static void addFriend (ChuddyUser newFriend) {
        UserService.addFriend(newFriend, ChuddyDataHandler.getUserLoggedIn());
    }
    public static List<ChuddyUser> getAllUsersNotFriended(){
        return ChuddyDataHandler.allUsersNotFriended();
    }
    public static List<ChuddyUser> getAllFriends() {
        return ChuddyDataHandler.allFriends();
    }

    public static ChuddyUser getCurrentUser() {
        return ChuddyDataHandler.getUserLoggedIn();
    }

}
