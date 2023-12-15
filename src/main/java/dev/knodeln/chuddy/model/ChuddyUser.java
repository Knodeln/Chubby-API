package dev.knodeln.chuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.knodeln.chuddy.controller.ForumController;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "chuddyUsers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuddyUser {

    @Id
    private ObjectId id;

    private String name;

    private String age;

    private String userDescription;

    private String edProgramme;

    private String year;

    private String gender;

    private String profilePicture;

    private List<String> interests;

    public String getName() {
        return name;
    }

    public static List<DiscussionThread> getUserThreads(ChuddyUser user) {
        List<DiscussionThread> userThreads = new ArrayList<>();

        for (DiscussionThread thread : ForumController.getDiscussionThreads()) {
            if (thread.containsUser(user)) {
                userThreads.add(thread);
            }
        }
        return userThreads;

    }

    ChuddyUser(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ChuddyUser user = new ChuddyUser("Senja");
        System.out.println(user.name);
    }
}
