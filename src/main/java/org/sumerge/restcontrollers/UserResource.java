package org.sumerge.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sumerge.models.UserModel;
import org.sumerge.services.UserResourceCtrl;
import org.sumerge.services.UserService;

import java.util.List;

import static org.sumerge.common.Utilities.getMessageEn;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserResource {

    private static final String USER_CREATED = "user.create";

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService, UserResourceCtrl userResourceCtrl) {
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
        return ResponseEntity.ok().body(getMessageEn(USER_CREATED));
    }
}
