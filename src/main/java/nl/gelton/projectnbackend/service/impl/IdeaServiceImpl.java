package nl.gelton.projectnbackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import nl.gelton.projectnbackend.dto.LikeRequest;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.IdeaInputDto;
import nl.gelton.projectnbackend.dto.mapper.CommentMapper;
import nl.gelton.projectnbackend.dto.mapper.IdeaMapper;
import nl.gelton.projectnbackend.dto.output.CommentOutputDto;
import nl.gelton.projectnbackend.dto.output.IdeaOutputDto;
import nl.gelton.projectnbackend.exception.RecordNotFoundException;
import nl.gelton.projectnbackend.model.Comment;
import nl.gelton.projectnbackend.model.Idea;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.IdeaRepository;
import nl.gelton.projectnbackend.repository.UserRepository;
import nl.gelton.projectnbackend.service.IdeaService;
import nl.gelton.projectnbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdeaServiceImpl implements IdeaService {

    private final IdeaRepository ideaRepository;
    private final UserService userService;
//    private final CommentRepository commentRepository;
    private final UserRepository userRepository;


    @Override
    public Response createIdea(IdeaInputDto ideaInputDto) {
          User user = userService.getLoggedUser();
//          ideaInputDto.setUser(user);
        Idea idea = IdeaMapper.fromInputDtoToModel(ideaInputDto);
        idea.setUser(user);
        idea.setCreatedAt(LocalDateTime.now());
        ideaRepository.save(idea);

        return Response.builder()
                .statusCode(200)
                .statusMessage("Idea Created Successfully")
                .idea(IdeaMapper.fromModelToOutputDto(idea))
                .build();
    }

    @Override
    public Response getAllIdeas() {
        List<Idea> ideas = ideaRepository.findAll();
        List<IdeaOutputDto> ideaOutputDtos = new ArrayList<>();
//        List<Comment> comments = commentRepository.findAll();
//
//        for (Idea idea : ideas) {
//            idea.setComments(comments);
//        }

        for (Idea idea : ideas) {
            ideaOutputDtos.add(IdeaMapper.fromModelToOutputDto(idea));
        }

        return Response.builder()
                .statusCode(200)
                .statusMessage("Ideas Found Successfully")
                .ideaList(ideaOutputDtos)
                .build();
    }
//
    @Override
    public Response getIdeaById(Long ideaId) {
        Idea idea = ideaRepository.findById(ideaId).orElseThrow(()-> new RecordNotFoundException("Idea Not Found"));
        IdeaOutputDto ideaOutputDto = IdeaMapper.fromModelToOutputDto(idea);

        return Response.builder()
                .statusCode(200)
                .statusMessage("Idea Found Successfully")
                .idea(ideaOutputDto)
                .build();
    }
//
//
    @Override
    public Response updateIdea(Long ideaId, IdeaInputDto ideaInputDto) {
        Idea idea = ideaRepository.findById(ideaId).orElseThrow(()-> new RecordNotFoundException("Idea Not Found!"));
        idea.setTitle(ideaInputDto.getTitle());
        idea.setDescription(ideaInputDto.getDescription());
        ideaRepository.save(idea);

        return Response.builder()
                .statusCode(200)
                .statusMessage("Idea Updated Successfully")
                .idea(IdeaMapper.fromModelToOutputDto(idea))
                .build();
    }

    @Override
    public Response deleteIdea(Long ideaId) {
        Idea idea = ideaRepository.findById(ideaId).orElseThrow(()-> new RecordNotFoundException("Idea Not Found!"));
        ideaRepository.delete(idea);
        return Response.builder()
                .statusCode(200)
                .statusMessage("Idea Deleted Successfully")
                .build();
    }

    @Override
    public Response getAllIdeasByUser(Long userId) {

//        User user = userRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("User Not Found!"));

        List<Idea> ideas = ideaRepository.findByUserId(userId);
        List<IdeaOutputDto> ideaOutputDtos = new ArrayList<>();

        for (Idea idea : ideas) {
            ideaOutputDtos.add(IdeaMapper.fromModelToOutputDto(idea));
        }

        return Response.builder()
                .statusCode(200)
                .statusMessage("Ideas From User Found Successfully")
                .ideaList(ideaOutputDtos)
                .build();
    }

    @Override
    public Response likeIdea(Long ideaId){
        Idea idea = ideaRepository.findById(ideaId).orElseThrow(()-> new RecordNotFoundException("Idea Not Found!"));
//        System.out.println("Begin");
        Set<User> updateUserLikes = idea.getUserLikes();
        System.out.println("updateUserLikes: " + updateUserLikes);

        String statusMessage;
        User user = userService.getLoggedUser();
        System.out.println("user: " + user);

        if(updateUserLikes.contains(user)){
            updateUserLikes.remove(user);
            idea.setUserLikes(updateUserLikes);
//            Set<Idea> likedIdeas = user.getLikedIdeas();
//            likedIdeas.remove(idea);
//            user.setLikedIdeas(likedIdeas);
            statusMessage = "Idea already Liked";
        } else {
            updateUserLikes.add(userService.getLoggedUser());
            idea.setUserLikes(updateUserLikes);
            statusMessage =  "Idea Liked Successfully";
        }
        System.out.println("statusmsg: " + statusMessage);

        System.out.println("updateUserLikes: " + updateUserLikes);

        ideaRepository.save(idea);


//        if (updateUserLikes.contains(user)) {
//            idea.setUserLikes(updateUserLikes);
//        } else {
//            updateUserLikes.add(user);
//            idea.setUserLikes(updateUserLikes);
//        }

//        System.out.println("like idea na add: " + updateUserLikes.size());
//
//        System.out.println(" idea na add: " + idea.getUserLikes());

        return Response.builder()
                .statusCode(200)
                .statusMessage(statusMessage)
                .idea(IdeaMapper.fromModelToOutputDto(idea))
                .build();
    }

//    @Override
//    public Response unLikeIdea(Long ideaId){
//
//        Idea idea = ideaRepository.findById(ideaId).orElseThrow(()-> new RecordNotFoundException("Idea Not Found!"));
//        System.out.println("Begin");
//        Set<User> updateUserLikes = idea.getUserLikes();
//
//        System.out.println("Eind");
//        String statusMessage;
//
//        if(updateUserLikes.contains(userService.getLoggedUser())){
//            updateUserLikes.remove(userService.getLoggedUser());
//            idea.setUserLikes(updateUserLikes);
//            statusMessage = "Idea UnLiked Successfully";
//        } else {
//            updateUserLikes.add(userService.getLoggedUser());
//            idea.setUserLikes(updateUserLikes);
//            statusMessage =  "Idea already UnLiked";
//        }
//
//        ideaRepository.save(idea);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage(statusMessage)
//                .idea(IdeaMapper.fromModelToOutputDto(idea))
//                .build();
//    }
//        Idea idea = ideaRepository.findById(ideaId).orElseThrow(()-> new RecordNotFoundException("Idea Not Found!"));
//        User user = userRepository.findById(userId).orElseThrow(()-> new RecordNotFoundException("User Not Found!"));
//        Set<User> userLikes= idea.getUserLikes();
//        if (userLikes.contains(user)) {
//            userLikes.remove(user);
//            idea.setUserLikes(userLikes);
//        } else {
//            idea.setUserLikes(userLikes);
//        }
//        ideaRepository.save(idea);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Like verwijderd")
//                .idea(IdeaMapper.fromModelToOutputDto(idea))
//                .build();
//    }

//    @Override
//    public Response getAllIdeasFromUser(Long userId) {
//
//        List<Idea> ideasFromUser = ideaRepository.findByUserId(userId);
//        List<IdeaOutputDto> ideaDtoList = new ArrayList<>();
//
//        for (Idea idea : ideasFromUser) {
//            ideaDtoList.add(IdeaMapper.fromModelToOutputDto(idea));
//        }
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("All ideas from user found!")
//                .ideaList(ideaDtoList)
//                .build();
//
//    }

}
