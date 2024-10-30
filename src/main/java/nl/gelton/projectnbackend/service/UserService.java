package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.dto.LoginRequest;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.UserInputDto;
import nl.gelton.projectnbackend.model.User;
import org.springframework.core.io.Resource;

public interface UserService {

    Response registerUser(UserInputDto registrationRequest);

    Response loginUser(LoginRequest loginRequest);

//    Response getAllUsers();

    User getLoggedUser();

    Response getUserInfoWithAddress();

    User assignAvatarToUser(String fileName, Long userId);

    Resource getAvatarFromUser(Long userId);
}
