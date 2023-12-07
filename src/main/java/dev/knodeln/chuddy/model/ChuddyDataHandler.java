package dev.knodeln.chuddy.model;

import dev.knodeln.chuddy.controller.ChuddyUserController;

import java.util.List;

public class ChuddyDataHandler {

    private static List<ChuddyUser> allUsers;

    public static List<ChuddyUser> getAllUsers() {
        return allUsers;
    }

    public static void startUp() {
        allUsers = UserService.deserializeUserListFromJson("chuddyUsers.json");
    }
    public static void shutDown() {
        UserService.serializeUsersToJson(allUsers, "chuddyUsers.json");

    }
}
