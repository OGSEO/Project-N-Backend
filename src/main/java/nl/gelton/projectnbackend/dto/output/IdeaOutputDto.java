package nl.gelton.projectnbackend.dto.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class IdeaOutputDto {

    private Long id;
    private String title;
    private String description;
    private String user;
//      private List<CommentOutputDto> comments;
    private Set<String> userLikes;
    private Set<String> politicalSupports;
    private LocalDateTime createdAt;
}
