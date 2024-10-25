package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.AddressInputDto;

public interface AddressService {

    Response saveAndUpdateAddress(AddressInputDto addressInputDto);
}
