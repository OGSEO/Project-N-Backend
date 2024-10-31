package nl.gelton.projectnbackend.dto.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import nl.gelton.projectnbackend.enums.UserRole;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {

    private Long id;
    private String name;
    private String email;
    private UserRole role;
    private AddressOutputDto Address;
//    private ProfileImage profileImage;
//    private PoliticalPartyOutputDto politicalParty; //Edit
//    private List<IdeaOutputDto> ideas;
//    private Set<IdeaOutputDto> likedIdeas;
    //    private List<CommentOutputDto> comments;
//    private LocalDateTime createdAt;
}
