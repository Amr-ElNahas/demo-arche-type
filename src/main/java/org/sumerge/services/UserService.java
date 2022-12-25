package org.sumerge.services;

import org.springframework.stereotype.Service;
import org.sumerge.models.UserEntity;
import org.sumerge.models.UserModel;
import org.sumerge.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserModel> findAllUsers(){
        return mapUsersListFromEntities(this.userRepository.findAll());
    }

    public List<UserModel> mapUsersListFromEntities(List<UserEntity> userEntityList) {
        List<UserModel> userModels = new ArrayList<>();
        userEntityList.stream().map(this::mapUserModelFromEntity).
                forEach(userModels::add);
        return userModels;
    }

    public UserModel mapUserModelFromEntity(UserEntity userEntity) {
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId().toString());
        userModel.setName(userEntity.getName());
        return userModel;
    }
}
