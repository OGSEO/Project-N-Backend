package nl.gelton.projectnbackend.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class PoliticalPartyInputDto {

    private String name;
    private String description;

}
