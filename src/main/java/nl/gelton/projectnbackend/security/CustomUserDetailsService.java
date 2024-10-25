package nl.gelton.projectnbackend.security;

import lombok.RequiredArgsConstructor;
import nl.gelton.projectnbackend.exception.RecordNotFoundException;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RecordNotFoundException("User/Email Not Found"));

        return CustomUserDetails.builder()
                .user(user)
                .build();
    }
}