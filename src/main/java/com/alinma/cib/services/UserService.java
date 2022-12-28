package com.alinma.cib.services;

import com.alinma.cib.models.UserEntity;
import com.alinma.cib.models.UserModel;
import com.alinma.cib.repositories.UserRepository;
import org.springframework.stereotype.Service;

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
    public UserEntity mapUserEntityFromModel(UserModel userModel){
        UserEntity userEntity=new UserEntity();
        userEntity.setId(0l);
        userEntity.setName(userModel.getName());
        return userEntity;
    }
    public void addUser(UserModel userModel){
        this.userRepository.save(mapUserEntityFromModel(userModel));
    }
}
