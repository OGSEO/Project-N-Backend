package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.IdeaInputDto;

public interface IdeaService {

    Response createIdea(IdeaInputDto ideaInputDto);

    Response getAllIdeas();

    Response getAllIdeasByUser(Long userId);

    Response getIdeaById(Long ideaId);

    Response updateIdea(Long ideaId, IdeaInputDto ideaInputDto);

    Response deleteIdea(Long ideaId);

    Response likeIdea(Long ideaId);

    Response unLikeIdea(Long ideaId);
}
