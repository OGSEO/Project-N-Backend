package nl.gelton.projectnbackend.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import nl.gelton.projectnbackend.enums.UserRole;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class UserInputDto {

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private UserRole role;
}


