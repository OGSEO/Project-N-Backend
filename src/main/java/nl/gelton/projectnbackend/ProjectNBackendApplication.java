package nl.gelton.projectnbackend;

import nl.gelton.projectnbackend.enums.UserRole;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectNBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectNBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            var user = User.builder()
                    .name("Ollie Gelton")
                    .email("o@g.nl")
                    .password(passwordEncoder.encode("qwerty"))
                    .role(UserRole.CITIZEN)
                    .build();
            userRepository.save(user);
        };
    }

}
