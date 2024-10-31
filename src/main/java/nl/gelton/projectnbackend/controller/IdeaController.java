package nl.gelton.projectnbackend.controller;

import lombok.RequiredArgsConstructor;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.IdeaInputDto;
import nl.gelton.projectnbackend.service.IdeaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/idea")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('CITIZEN')")
    public ResponseEntity<Response> createIdea(@RequestBody IdeaInputDto ideaInputDto) {
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand()
//                .toUri();
        return ResponseEntity.ok(ideaService.createIdea(ideaInputDto));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Response> getAllIdeas() {
        return ResponseEntity.ok(ideaService.getAllIdeas());
    }

    @GetMapping("/get-all-by-user/{userId}")
    public ResponseEntity<Response> getAllIdeasFromUser(@PathVariable Long userId) {
        return ResponseEntity.ok(ideaService.getAllIdeasByUser(userId));
    }

    @GetMapping("/get-idea-by-id")
    public ResponseEntity<Response> getIdeaById(@RequestParam("ideaId") Long ideaId) {
        return ResponseEntity.ok(ideaService.getIdeaById(ideaId));
    }

//    @GetMapping("/get-all-from-user")
//    public ResponseEntity<Response> getAllIdeasFromUser(@RequestParam Long userId) {
//        return ResponseEntity.ok(ideaService.getAllIdeasFromUser(userId));
//    }

    @PutMapping("/update/{ideaId}")
    @PreAuthorize("hasAuthority('CITIZEN')")
    public ResponseEntity<Response> updateIdea(@PathVariable Long ideaId,
                                               @RequestBody IdeaInputDto ideaInputDto) {
        return ResponseEntity.ok(ideaService.updateIdea(ideaId, ideaInputDto));
    }

    @DeleteMapping("/delete/{ideaId}")
    @PreAuthorize("hasAuthority('CITIZEN')")
    public ResponseEntity<Response> deleteIdea(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.deleteIdea(ideaId));
    }

    @PostMapping("/like-idea/{ideaId}")
    public ResponseEntity<Response> likeIdea(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.likeIdea(ideaId));
    }

    @PostMapping("/unlike-idea/{ideaId}")
    public ResponseEntity<Response> unLikeIdea(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.unLikeIdea(ideaId));
    }

    @PostMapping("/support-idea/{ideaId}")
    public ResponseEntity<Response> supportIdea(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.supportIdea(ideaId));
    }

    @PostMapping("/unsupport-idea/{ideaId}")
    public ResponseEntity<Response> unSupportIdea(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.unSupportIdea(ideaId));
    }

}
