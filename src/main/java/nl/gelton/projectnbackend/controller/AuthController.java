package nl.gelton.projectnbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import nl.gelton.steunideebackend.service.impl.UserService;
import nl.gelton.projectnbackend.dto.LoginRequest;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.UserInputDto;
import nl.gelton.projectnbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserInputDto registerRequest) {
        return ResponseEntity.ok(userService.registerUser(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }





//    @GetMapping("/user")
//    public ResponseEntity<?> getUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
//        User user = userService.findByUsername(userDetails.getUsername());
//
//
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//
//        UserInfoRespponse response = new UserInfoRespponse(
//                user.getUserId(),
//                user.getFirstname(),
//                user.getLastname(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getAvatarImage(),
//                user.isAccountNonLocked(),
//                user.isAccountNonExpired(),
//                user.isCredentialsNonExpired(),
//                user.isEnabled(),
//                user.getCredentialsExpiryDate(),
//                user.getAccountExpiryDate(),
//                user.isTwoFactorEnabled(),
//                roles
//        );
//
//
//        return ResponseEntity.ok().body(response);
//    }

//
//    @PostMapping("/user/avatar")
//    public ResponseEntity<User> addAvatarToUser(@AuthenticationPrincipal UserDetails userDetails,
//                                                @RequestBody MultipartFile avatarFile) throws IOException {
//        String username = userDetails.getUsername();
//
//
//        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/auth")
//                .path(Objects.requireNonNull(username))
//                .path("/avatar")
//                .toUriString();
//
//
//        AvatarImage avatarImage = avatarService.storeFile(avatarFile, url);
//
//
//        User user = userService.addAvatar(username, avatarImage);
//
//
//        return ResponseEntity.created(URI.create(url)).body(user);
//    }
//
//
//    @GetMapping("/user/avatar")
//    public ResponseEntity<byte[]> getUserAvatar(@AuthenticationPrincipal UserDetails userDetails) {
//
//
//        AvatarImage avatarImage = userService.getAvatarFromUser(userDetails.getUsername());
//
//
//        MediaType mediaType;
//
//
//        try {
//            mediaType = MediaType.parseMediaType(avatarImage.getContentType());
//        } catch (InvalidMediaTypeException ignore) {
//            mediaType = MediaType.APPLICATION_OCTET_STREAM;
//        }
//
//
//        return ResponseEntity.ok().contentType(mediaType)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + avatarImage.getTitle())
//                .body(avatarImage.getImage());
//    }
//
//
//    @GetMapping("/username")
//    public String currentUsername(@AuthenticationPrincipal UserDetails userDetails) {
//        return (userDetails != null) ? userDetails.getUsername() : "";
//    }
}





