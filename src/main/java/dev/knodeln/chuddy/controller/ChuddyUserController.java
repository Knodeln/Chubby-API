package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chuddyusers")
@CrossOrigin(origins = "*")

public class ChuddyUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<ChuddyUser>> allUsers() {
        return new ResponseEntity<List<ChuddyUser>>(userService.GetAllUsers(), HttpStatus.OK);
    }
    public ChuddyUser createNewUser() {
        return new ChuddyUser();
    }
    public void deleteUser() {

    }

}
