package nl.gelton.projectnbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import nl.gelton.projectnbackend.dto.output.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;
    private String statusMessage;
    private final LocalDateTime timestamp= LocalDateTime.now();

    private String token;
    private String role;
    private String expirationTime;

    private UserOutputDto user;
    private AddressOutputDto address;
    private PoliticalPartyOutputDto party;
    private IdeaOutputDto idea;
    private CommentOutputDto comment;

    private List<UserOutputDto> userList;
    private List<PoliticalPartyOutputDto> partyList;
    private List<IdeaOutputDto> ideaList;
    private List<CommentOutputDto> commentList;

//    private ProfileImage profileImage;

}
