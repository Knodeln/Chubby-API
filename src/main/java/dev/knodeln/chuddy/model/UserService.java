package dev.knodeln.chuddy.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.knodeln.chuddy.Exceptions.UserNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public static void manageLogin(String email, String password) throws UserNotFoundException {
        boolean userFound = false;
        for (ChuddyUser user : ChuddyDataHandler.getAllUsers())
            if (user.getEmail().equals(email) & user.getPassword().equals(password)) {
                ChuddyDataHandler.setUserLoggedIn(user);
                userFound = true;
            }
        if (!userFound) {
            throw new UserNotFoundException("User could not be found");
        }
    }
    public static void updateUser(ChuddyUser user, String name, String age, String description, String edProgramme, String year, String gender, String profilePicture) {
        user.setName(name);
        user.setAge(age);
        user.setUserDescription(description);
        user.setEdProgramme(edProgramme);
        user.setYear(year);
        user.setGender(gender);
        user.setProfilePicture(profilePicture);
    }
}
