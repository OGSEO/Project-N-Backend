package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.dto.LoginRequest;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.UserInputDto;
import nl.gelton.projectnbackend.model.User;

public interface UserService {

    Response registerUser(UserInputDto registrationRequest);

    Response loginUser(LoginRequest loginRequest);

//    Response getAllUsers();

    User getLoggedUser();

    Response getUserInfoWithAddress();
}
