package nl.gelton.projectnbackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.CommentInputDto;
import nl.gelton.projectnbackend.dto.mapper.CommentMapper;
import nl.gelton.projectnbackend.dto.output.CommentOutputDto;
import nl.gelton.projectnbackend.exception.RecordNotFoundException;
import nl.gelton.projectnbackend.model.Comment;
import nl.gelton.projectnbackend.model.Idea;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.CommentRepository;
import nl.gelton.projectnbackend.repository.IdeaRepository;
import nl.gelton.projectnbackend.repository.UserRepository;
import nl.gelton.projectnbackend.service.CommentService;
import nl.gelton.projectnbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final IdeaRepository ideaRepository;
    private final UserService userService;

    @Override
    public Response getAllCommentsByIdea(Long ideaId) {
        List<Comment> comments = commentRepository.findByIdeaId(ideaId);
        List<CommentOutputDto> commentOutputDtos = new ArrayList<>();

        for (Comment comment : comments) {
            commentOutputDtos.add(CommentMapper.fromModelToOutputDto(comment));
        }

        return Response.builder()
                .statusCode(200)
                .statusMessage("Comments Found Successfully")
                .commentList(commentOutputDtos)
                .build();
    }




//    @Override
//    public Response getCommentById(Long commentId) {
//        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new RecordNotFoundException("Comment Not Found"));
//        CommentOutputDto commentOutputDto = CommentMapper.fromModelToOutputDto(comment);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Comment Found Successfully")
//                .comment(commentOutputDto)
//                .build();
//    }

    @Override
    public Response createComment(CommentInputDto commentInputDto, Long ideaId) {

        User user = userService.getLoggedUser();
        Idea idea = ideaRepository.findById(ideaId).orElseThrow(() -> new RecordNotFoundException("Idea not found!"));
//        User user = userRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("User not found!"));
//        List<Comment> ideaComments = idea.getComments();  // testing
        Comment comment = CommentMapper.fromInputDtoToModel(commentInputDto);
//        idea.setComments(ideaComments);
        comment.setIdea(idea);
        comment.setUser(user);
//        ideaComments.add(comment); //testing
//        ideaRepository.save(idea); //testing
        commentRepository.save(comment);

        return Response.builder()
                .statusCode(200)
                .statusMessage("Comment Party Created Successfully")
                .comment(CommentMapper.fromModelToOutputDto(comment))
                .build();
    }

//    @Override
//    public Response updateComment(Long commentId, CommentInputDto commentInputDto) {
//        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new RecordNotFoundException("Comment Not Found!"));
//        comment.setContent(commentInputDto.getContent());
//        commentRepository.save(comment);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Comment Party Updated Successfully")
//                .comment(CommentMapper.fromModelToOutputDto(comment))
//                .build();
//    }
//
//    @Override
//    public Response deleteComment(Long commentId) {
//        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new RecordNotFoundException("Comment Not Found!"));
//        commentRepository.delete(comment);
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Comment Deleted Successfully")
//                .build();
//    }

}
