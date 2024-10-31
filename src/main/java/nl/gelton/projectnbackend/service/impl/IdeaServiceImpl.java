package nl.gelton.projectnbackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.IdeaInputDto;
import nl.gelton.projectnbackend.dto.mapper.IdeaMapper;
import nl.gelton.projectnbackend.dto.output.IdeaOutputDto;
import nl.gelton.projectnbackend.exception.RecordNotFoundException;
import nl.gelton.projectnbackend.model.Idea;
import nl.gelton.projectnbackend.model.PoliticalParty;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.IdeaRepository;
import nl.gelton.projectnbackend.repository.PoliticalPartyRepository;
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
    private final UserRepository userRepository;
    private final PoliticalPartyRepository politicalPartyRepository;


    @Override
    public Response createIdea(IdeaInputDto ideaInputDto) {
        User user = userService.getLoggedUser();
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
        Idea ideaToLike = ideaRepository.findById(ideaId).orElseThrow(() -> new RecordNotFoundException("Idea Not Found!"));

        Set<User> updateUserLikes = ideaToLike.getUserLikes();

        String statusMessage;
        User user = userService.getLoggedUser();

        if(updateUserLikes.contains(user)){
            statusMessage = "Idea already Liked";
        } else {
            updateUserLikes.add(userService.getLoggedUser());
            ideaToLike.setUserLikes(updateUserLikes);
            statusMessage =  "Idea Liked Successfully";
        }

        ideaRepository.save(ideaToLike);

        return Response.builder()
                .statusCode(200)
                .statusMessage(statusMessage)
                .idea(IdeaMapper.fromModelToOutputDto(ideaToLike))
                .build();
    }

    @Override
    public Response supportIdea(Long ideaId) {
        Idea ideaToSupport = ideaRepository.findById(ideaId).orElseThrow(() -> new RecordNotFoundException("Idea Not Found!"));

        Set<PoliticalParty> updatePoliticalSupports = ideaToSupport.getPoliticalSupports();

        String statusMessage;
        User user = userService.getLoggedUser();
        PoliticalParty politicalParty = politicalPartyRepository.findByUserId(user.getId());
//        PoliticalParty politicalParty = user.getPoliticalParty();
        if(updatePoliticalSupports.contains(politicalParty)){
            statusMessage = "Idea already Support";
        } else {
            updatePoliticalSupports.add(politicalParty);
            ideaToSupport.setPoliticalSupports(updatePoliticalSupports);
            statusMessage =  "Idea Supported Successfully";
        }
        ideaRepository.save(ideaToSupport);

        return Response.builder()
                .statusCode(200)
                .statusMessage(statusMessage)
                .idea(IdeaMapper.fromModelToOutputDto(ideaToSupport))
                .build();
    }

    @Override
    public Response unLikeIdea(Long ideaId) {
        Idea ideaToUnLike = ideaRepository.findById(ideaId).orElseThrow(() -> new RecordNotFoundException("Idea Not Found!"));

        Set<User> updateUserLikes = ideaToUnLike.getUserLikes();

        String statusMessage;
        User user = userService.getLoggedUser();

        if(updateUserLikes.contains(user)){
            updateUserLikes.remove(user);
            ideaToUnLike.setUserLikes(updateUserLikes);
            statusMessage = "Idea unLiked Successfully";
        } else {
            statusMessage =  "Idea already unLiked";
        }

        ideaRepository.save(ideaToUnLike);

        return Response.builder()
                .statusCode(200)
                .statusMessage(statusMessage)
                .idea(IdeaMapper.fromModelToOutputDto(ideaToUnLike))
                .build();
    }

    @Override
    public Response unSupportIdea(Long ideaId) {
        Idea ideaToUnSupport = ideaRepository.findById(ideaId).orElseThrow(() -> new RecordNotFoundException("Idea Not Found!"));

        Set<PoliticalParty> updatePolitcalSupports = ideaToUnSupport.getPoliticalSupports();

        String statusMessage;
        User user = userService.getLoggedUser();
        PoliticalParty politicalParty = politicalPartyRepository.findByUserId(user.getId());
//        PoliticalParty politicalParty = user.getPoliticalParty();

        if(updatePolitcalSupports.contains(politicalParty)){
            updatePolitcalSupports.remove(politicalParty);
            ideaToUnSupport.setPoliticalSupports(updatePolitcalSupports);
            statusMessage = "Idea unSupported Successfully";
        } else {
            statusMessage =  "Idea already unSupported";
        }

        ideaRepository.save(ideaToUnSupport);

        return Response.builder()
                .statusCode(200)
                .statusMessage(statusMessage)
                .idea(IdeaMapper.fromModelToOutputDto(ideaToUnSupport))
                .build();

    }
}
