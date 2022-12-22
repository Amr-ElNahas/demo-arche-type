package org.sumerge.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.sumerge.models.UserModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEvent {
    @JsonProperty("operation")
    private Operations operation;
    @JsonProperty("data")
    private UserModel data;
    @JsonProperty("descriptionAr")
    private String descriptionAr;
    @JsonProperty("description")
    private String description;


    public enum Operations {
        CREATE,
        DELETE,
        UPDATE,

    }

}
