package nl.gelton.projectnbackend.dto.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CommentOutputDto {

    private Long id;
    private String content;
    private UserOutputDto user;
    private IdeaOutputDto idea;
    private LocalDateTime createdAt;

}