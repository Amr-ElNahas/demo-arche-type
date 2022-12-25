package org.sumerge.services;

import org.springframework.stereotype.Component;
import org.sumerge.models.UserDocument;
import org.sumerge.models.UserModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserResourceCtrl {
    public List<UserModel> mapUsersListFromEntities(List<UserDocument> userDocumentList) {
        List<UserModel> userModels = new ArrayList<>();
        userDocumentList.stream().map(this::mapUserModelFromEntity).
                forEach(userModels::add);
        return userModels;
    }

    public UserModel mapUserModelFromEntity(UserDocument userDocument) {
        UserModel userModel = new UserModel();
        userModel.setId(userDocument.getId().toString());
        userModel.setName(userDocument.getName());
        return userModel;
    }
}
