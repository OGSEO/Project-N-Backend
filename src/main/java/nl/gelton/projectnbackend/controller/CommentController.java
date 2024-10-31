package nl.gelton.projectnbackend.controller;

import lombok.RequiredArgsConstructor;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.CommentInputDto;
import nl.gelton.projectnbackend.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create/{ideaId}")
    @PreAuthorize("hasAuthority('CITIZEN')")
    public ResponseEntity<Response> createComment(@RequestBody CommentInputDto commentInputDto,
                                                  @PathVariable Long ideaId) {
        return ResponseEntity.ok(commentService.createComment(commentInputDto, ideaId));
    }

    @GetMapping("/get-all-by-idea/{ideaId}")
    public ResponseEntity<Response> getAllIdeas(@PathVariable Long ideaId) {
        return ResponseEntity.ok(commentService.getAllCommentsByIdea(ideaId));
    }

//
//    @PutMapping("/update/{commentId}")
//    @PreAuthorize("hasAuthority('CITIZEN')")
//    public ResponseEntity<Response> updateComment(@PathVariable Long commentId,
//                                                  @RequestBody CommentInputDto commentInputDto) {
//        return ResponseEntity.ok(commentService.updateComment(commentId, commentInputDto));
//    }
//
//    @DeleteMapping("/delete/{commentId}")
//    @PreAuthorize("hasAuthority('CITIZEN')")
//    public ResponseEntity<Response> deleteComment(@PathVariable Long commentId) {
//        return ResponseEntity.ok(commentService.deleteComment(commentId));
//    }
//
//    @GetMapping("/get-comment-by-id/{commentId}")
//    public ResponseEntity<Response> getCommentById(@PathVariable Long commentId) {
//        return ResponseEntity.ok(commentService.getCommentById(commentId));
//    }
}
