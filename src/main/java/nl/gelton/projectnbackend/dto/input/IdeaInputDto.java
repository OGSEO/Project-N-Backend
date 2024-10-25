package nl.gelton.projectnbackend.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import nl.gelton.projectnbackend.model.User;

import java.util.Set;


@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class IdeaInputDto {

    private String title;
    private String description;
//      private User user;
}
