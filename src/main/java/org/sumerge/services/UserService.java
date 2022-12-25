package org.sumerge.services;

import org.springframework.stereotype.Service;
import org.sumerge.models.UserModel;
import org.sumerge.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserResourceCtrl userResourceCtrl;
    public UserService(UserRepository userRepository,UserResourceCtrl userResourceCtrl){
        this.userRepository=userRepository;
        this.userResourceCtrl = userResourceCtrl;
    }

    public List<UserModel> findAllUsers(){
        return userResourceCtrl.mapUsersListFromEntities(this.userRepository.findAll());
    }
}
