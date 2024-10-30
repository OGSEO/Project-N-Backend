package nl.gelton.projectnbackend.dto.mapper;

import nl.gelton.projectnbackend.dto.input.IdeaInputDto;
import nl.gelton.projectnbackend.dto.output.CommentOutputDto;
import nl.gelton.projectnbackend.dto.output.IdeaOutputDto;
import nl.gelton.projectnbackend.dto.output.UserOutputDto;
import nl.gelton.projectnbackend.model.Comment;
import nl.gelton.projectnbackend.model.Idea;
import nl.gelton.projectnbackend.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IdeaMapper {

    public static Idea fromInputDtoToModel(IdeaInputDto ideaInputDto) {
        Idea idea = new Idea();
        idea.setTitle(ideaInputDto.getTitle());
        idea.setDescription(ideaInputDto.getDescription());
//        idea.setUser(ideaInputDto.getUser());
        return idea;
    }

    public static IdeaOutputDto fromModelToOutputDto(Idea idea) {
        IdeaOutputDto ideaOutputDto = new IdeaOutputDto();
        ideaOutputDto.setId(idea.getId());
        ideaOutputDto.setTitle(idea.getTitle());
        ideaOutputDto.setDescription(idea.getDescription());
        ideaOutputDto.setCreatedAt(idea.getCreatedAt());
        ideaOutputDto.setUser(UserMapper.fromModelToOutputDto(idea.getUser()).getName());
//        ideaOutputDto.setComments(CommentMapper.fromModelToOutputDto(idea.getComments()));


//        if (idea.getUserLikes() != null) {
        Set<String> userLikeDtos = new HashSet<>();
        Set<User> userLikes = idea.getUserLikes();
        System.out.println("userLikes: " +userLikes.size());
        for (User user : userLikes) {
            userLikeDtos.add(UserMapper.fromModelToOutputDto(user).getName());
        }
        ideaOutputDto.setUserLikes(userLikeDtos);

//        List<CommentOutputDto> comments = new ArrayList<>();
//        List<Comment> commentList = idea.getComments();
//        for (Comment comment : commentList) {
//            comments.add(CommentMapper.fromModelToOutputDto(comment));
//        }
//        ideaOutputDto.setComments(comments);


//        for (Idea idea : ideas) {
//            ideaOutputDtos.add(IdeaMapper.fromModelToOutputDto(idea));
//        }
//
//        ideaOutputDto.setUserLikes(UserMapper.fromModelToOutputDto());


//        if (idea.getUserLikes() != null) {
//            Set<User> userLikes = idea.getUserLikes();
//            Set<UserOutputDto> userLikeDtos = new HashSet<>();
//
//            for (User user : userLikes) {
//                userLikeDtos.add(UserMapper.fromModelToOutputDto(user));
//            }
//
//            ideaOutputDto.setUserLikes(userLikeDtos);
//        }


//        if (idea.getComments() != null && !idea.getComments().isEmpty()) {
//
//            List<Comment> ideaComments = idea.getComments();
//            List<CommentOutputDto> commentDtos = new ArrayList<>();
//
//            for (Comment comment : ideaComments) {
//
//                commentDtos.add(CommentMapper.fromModelToOutputDto(comment));
//            }
//            ideaOutputDto.setComments(commentDtos);
//        }

//        if( idea.getUser() != null){
//            User user = new User();
//
//        }

        return ideaOutputDto;
    }


//    public static IdeaOutputDto fromModelToOutputDtoPlusComments(Idea idea) {
//        IdeaOutputDto ideaOutputDto = fromModelToOutputDto(idea);
//
//        if (idea.getComments() != null && !idea.getComments().isEmpty()) {
//            List<Comment> ideaComments = idea.getComments();
//
//            List<CommentOutputDto> commentDtos = new ArrayList<>();
//            for (Comment comment : ideaComments) {
//
//                commentDtos.add(CommentMapper.fromModelToOutputDto(comment));
//            }
//            ideaOutputDto.setComments(commentDtos);
//        }
//        return ideaOutputDto;
//    }
}
