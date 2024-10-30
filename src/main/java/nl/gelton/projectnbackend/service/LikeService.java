//package nl.gelton.projectnbackend.service;
//
//import lombok.RequiredArgsConstructor;
//import nl.gelton.projectnbackend.dto.Response;
//import nl.gelton.projectnbackend.exception.RecordNotFoundException;
//import nl.gelton.projectnbackend.model.Idea;
//import nl.gelton.projectnbackend.model.User;
//import nl.gelton.projectnbackend.repository.IdeaRepository;
//import nl.gelton.projectnbackend.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class LikeService {
//
//    private final IdeaRepository ideaRepository;
//    private final UserService userService;
//    private final UserRepository userRepository;
//
//    public Response placeLike(Long userId, Long ideaId) {
//
//        // vind idea waar like bij hoort!
//        Idea idea = ideaRepository.findById(ideaId)
//                .orElseThrow(() -> new RecordNotFoundException("Kon idea niet vinden"));
//
//        // vind user waar like bij hoort!
////        User user = userService.getLoggedUser();
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RecordNotFoundException("Kon user niet vinden"));
//        //voeg het idea toe aan likedIdeas en save de geupdatet user
////        Set<Idea> ideas = user.getLikedIdeas();
////        ideas.add(idea);
////        user.setLikedIdeas(ideas);
////        userRepository.save(user);
//
//        //voeg user toe aan userLikes en save het geupdatet idea
//        Set<User> users = idea.getUserLikes();
//        users.add(user);
//        idea.setUserLikes(users);
//        ideaRepository.save(idea);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Like toegevoegd")
//                .build();
//    }
//}
