package dev.knodeln.chuddy.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data   
@AllArgsConstructor
@NoArgsConstructor
public class ChuddyUser {

    private String name;

    private String age;

    public String email;

    public String password;

    private String userDescription;

    private String edProgramme;

    private String year;

    private String gender;

    private String profilePicture;

    private List<String> interests;

    private List<Conversation> conversations;

    private List<String> friends;

    public ChuddyUser(String name, String age, String email, String password, String edProgramme, String year, String gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.userDescription = "";
        this.edProgramme = edProgramme;
        this.year = year;
        this.gender = gender;
        this.profilePicture = null;
        this.interests = null;
        this.conversations = null;
        this.friends = new ArrayList<String>();
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
    

    public String getUserDescription() {
        return userDescription;
    }

    public String getEdProgramme() {
        return edProgramme;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void addConversation(Conversation conversation) {
        conversations.add(conversation);
    }
    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String newFriend) {
        this.friends.add(newFriend);
    }
}
