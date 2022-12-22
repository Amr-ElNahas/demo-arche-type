package org.sumerge.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sumerge.common.exceptions.UserNotFoundException;
import org.sumerge.models.UserEvent;
import org.sumerge.models.UserDocument;
import io.micrometer.core.instrument.util.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class UserConsumerCtrl {

    public UserDocument getUserDocument(UserEvent event) {
        UserDocument userDocument = new UserDocument();
        userDocument.setId(new ObjectId(event.getData().getId()));
        userDocument.setName(getObject(event).getName());
        return userDocument;
    }

    public UserDocument getObject(UserEvent event){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(event.getData(), UserDocument.class);
    }
    public UserDocument getDocument(LinkedHashMap event){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(event.get("data"), UserDocument.class);
    }

    public void validate(UserEvent userEvent) {
        if (userEvent == null  ||StringUtils.isBlank(userEvent.getData().getId()))
            throw new UserNotFoundException();
    }

    public UserEvent getModel(LinkedHashMap value) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(value, UserEvent.class);
    }
}
