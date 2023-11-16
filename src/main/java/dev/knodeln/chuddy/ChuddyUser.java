package dev.knodeln.chuddy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ChuddyUsers")
public class ChuddyUser {

    private ObjectId id;

    private String name;

    private Integer age;

    private String userDescription;

    private String edProgramme;

    private String year;

    private String gender;

    private String profilePicture;

    private List<String> userPictures;

}
