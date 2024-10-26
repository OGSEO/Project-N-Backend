package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.CommentInputDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommentService {

//    Response getAllComments(Long ideaId);
    Response getAllCommentsByIdea(Long ideaId);
//
//    Response getCommentById(Long commentId);

    Response createComment(CommentInputDto commentInputDto, Long ideaId);

//    Response updateComment(Long commentId, CommentInputDto commentInputDto);
//
//    Response deleteComment(Long commentId);
}
