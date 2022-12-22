package org.sumerge.services;

import org.sumerge.models.UserEvent;
import org.sumerge.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class EventProducerCtrl {
    public UserEvent getUserEvent(UserEvent.Operations operation, String description, String descriptionAr,
                                  UserModel userModel) {

        UserEvent topicEvent = new UserEvent(operation,userModel, description, descriptionAr);
        return topicEvent;
    }

}
