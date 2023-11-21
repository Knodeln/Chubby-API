package dev.knodeln.chuddy.model;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<ChuddyUser> GetAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }
}
