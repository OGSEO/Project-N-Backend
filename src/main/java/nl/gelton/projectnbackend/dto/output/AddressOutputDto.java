package nl.gelton.projectnbackend.dto.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class AddressOutputDto {

    private Long id;
    private String street;
    private String zipCode;
    private String city;
    private String country;

    private UserOutputDto user;

    private LocalDateTime createdAt;
}