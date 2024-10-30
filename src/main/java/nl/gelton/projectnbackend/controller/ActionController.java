//package nl.gelton.projectnbackend.controller;
//
//import lombok.RequiredArgsConstructor;
//import nl.gelton.projectnbackend.dto.Response;
//import nl.gelton.projectnbackend.service.LikeService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/action")
//@RequiredArgsConstructor
//public class ActionController {
//
//    private final LikeService likeService;
//
//    @PostMapping("like-idea/{userID}/{ideaId}")
//    public ResponseEntity<Response> likeIdea(@PathVariable Long userId, @PathVariable Long ideaId) {
//        return ResponseEntity.ok(likeService.placeLike(userId, ideaId));
//    }
//}
