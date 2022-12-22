package org.sumerge.consumer;

import org.sumerge.common.exceptions.UserNotFoundException;
import org.sumerge.services.UserConsumerCtrl;
import org.sumerge.models.UserEvent;
import org.sumerge.repositories.UserRepository;
import org.sumerge.models.UserDocument;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Optional;

import static org.sumerge.common.Constants.USER_TEST_TOPIC;

@Service
public class UserConsumer {

    private final UserConsumerCtrl userConsumerCtrl;
    private final UserRepository userRepository;
    private LinkedHashMap map;



    @Autowired
    public UserConsumer(UserConsumerCtrl userConsumerCtrl, UserRepository userRepository) {
        this.userConsumerCtrl = userConsumerCtrl;
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = USER_TEST_TOPIC)
    public void consume(ConsumerRecord<String, LinkedHashMap> record) {


        UserEvent eventModel = userConsumerCtrl.getModel(record.value());
        userConsumerCtrl.validate(eventModel);
        UserDocument userDocument = userConsumerCtrl.getDocument(record.value());

        Optional<UserDocument> engineeringOfficeOptional = userRepository.findById(userDocument.getId());

        switch (eventModel.getOperation()) {
            case DELETE:
                if (engineeringOfficeOptional.isEmpty())
                    throw new UserNotFoundException();
                userRepository.delete(userDocument);
                break;
            case UPDATE:
                if (engineeringOfficeOptional.isEmpty())
                    throw new UserNotFoundException();
                userRepository.save(userDocument);
            case CREATE:
            default:
                userRepository.save(userDocument);
                break;
        }
    }
}
