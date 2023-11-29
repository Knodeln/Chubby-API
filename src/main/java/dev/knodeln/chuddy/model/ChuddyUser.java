package dev.knodeln.chuddy.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public ChuddyUser(String name, String age, String userDescription, String edProgramme,
                        String year, String gender, String profilePicture) {
        this.name = name;
        this.age = age;
        this.userDescription = userDescription;
        this.edProgramme = edProgramme;
        this.year = year;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.interests = null;
    }
}

