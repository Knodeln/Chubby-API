package dev.knodeln.chuddy.model;

import com.fasterxml.jackson.databind.ObjectMapper;
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



    public static void serializeUsersToJson(List<ChuddyUser> existingUsers, String filePath) {
        try {


            // Write the updated list back to the file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), existingUsers);

            System.out.println("Serialization successful. File updated at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }
    // Example deserialization method to read a list of users from the file
    public static List<ChuddyUser> deserializeUserListFromJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            // Check if the file exists before reading
            if (!file.exists()) {
                return new ArrayList<>();
            }

            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ChuddyUser.class));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error during deserialization: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
