package nl.gelton.projectnbackend.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class AddressInputDto {

    private String street;
    private String zipCode;
    private String city;
    private String country;

}
