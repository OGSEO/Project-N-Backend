package nl.gelton.projectnbackend.service.impl;

import lombok.RequiredArgsConstructor;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.AddressInputDto;
import nl.gelton.projectnbackend.model.Address;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.AddressRepository;
import nl.gelton.projectnbackend.service.AddressService;
import nl.gelton.projectnbackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;

    @Override
    public Response saveAndUpdateAddress(AddressInputDto addressInputDto) {
        User user = userService.getLoggedUser();
        Address address = user.getAddress();

        if (address == null) {
            address = new Address();
            address.setUser(user);
        }
        if (addressInputDto.getStreet() != null) address.setStreet(addressInputDto.getStreet());
        if (addressInputDto.getZipCode() != null) address.setCity(addressInputDto.getZipCode());
        if (addressInputDto.getCity() != null) address.setCity(addressInputDto.getCity());
        if (addressInputDto.getCountry() != null) address.setCountry(addressInputDto.getCountry());

        addressRepository.save(address);

        String message = (user.getAddress() == null) ? "Address successfully created" : "Address successfully updated";

        return Response.builder()
                .statusCode(200)
                .statusMessage(message)
                .build();

    }
}
