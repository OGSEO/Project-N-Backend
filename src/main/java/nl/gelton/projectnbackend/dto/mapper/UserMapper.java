package nl.gelton.projectnbackend.dto.mapper;

import nl.gelton.projectnbackend.dto.input.UserInputDto;
import nl.gelton.projectnbackend.dto.output.AddressOutputDto;
import nl.gelton.projectnbackend.dto.output.UserOutputDto;
import nl.gelton.projectnbackend.model.User;

public class UserMapper {
    public static User fromInputDtoToModel(UserInputDto userInputDto) {
        User user = new User();
        user.setName(userInputDto.getName());
        user.setEmail(userInputDto.getEmail());
        user.setPassword(userInputDto.getPassword());
        user.setRole(userInputDto.getRole());
        return user;
    }

    public static UserOutputDto fromModelToOutputDto(User user) {
        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.setId(user.getId());
        userOutputDto.setName(user.getName());
        userOutputDto.setEmail(user.getEmail());
        userOutputDto.setRole(user.getRole());
//        if(user.getPoliticalParty() != null) {
//            userOutputDto.setPoliticalParty(PoliticalPartyMapper.fromModelToOutputDto(user.getPoliticalParty()));  //Edit
//        }
        return userOutputDto;
    }

    public static UserOutputDto fromModelToOutputDtoPlusAddress(User user) {
        UserOutputDto userOutputDto = fromModelToOutputDto(user);
        if (user.getAddress() != null) {
            AddressOutputDto addressOutputDto = AddressMapper.fromModelToOutputDto(user.getAddress());
            userOutputDto.setAddress(addressOutputDto);
        }
        return userOutputDto;
    }


}
