package com.alinma.cib.restcontrollers;

import com.alinma.cib.common.Utilities;
import com.alinma.cib.models.UserModel;
import com.alinma.cib.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserResource {

    private static final String USER_CREATED = "user.create";

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser() {
        UserModel userModel = new UserModel();
        userModel.setName("Ahmed Yousry");
        userService.addUser(userModel);
        return ResponseEntity.ok().body(Utilities.getMessageEn(USER_CREATED));
    }
}
