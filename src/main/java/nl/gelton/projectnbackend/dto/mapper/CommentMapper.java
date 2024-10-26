package nl.gelton.projectnbackend.dto.mapper;


import nl.gelton.projectnbackend.dto.input.CommentInputDto;
import nl.gelton.projectnbackend.dto.output.CommentOutputDto;
import nl.gelton.projectnbackend.model.Comment;

public class CommentMapper {

    public static Comment fromInputDtoToModel(CommentInputDto commentInputDto) {
        Comment comment = new Comment();
        comment.setContent(commentInputDto.getContent());
        return comment;
    }

    public static CommentOutputDto fromModelToOutputDto(Comment comment) {
        CommentOutputDto commentOutputDto = new CommentOutputDto();
        commentOutputDto.setId(comment.getId());
        commentOutputDto.setContent(comment.getContent());
        commentOutputDto.setCreatedAt(comment.getCreatedAt());
        commentOutputDto.setUser(UserMapper.fromModelToOutputDto(comment.getUser()));
        commentOutputDto.setIdea(IdeaMapper.fromModelToOutputDto(comment.getIdea()));
        return commentOutputDto;
    }

}
