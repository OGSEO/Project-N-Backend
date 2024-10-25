package nl.gelton.projectnbackend.dto.mapper;

import nl.gelton.projectnbackend.dto.input.AddressInputDto;
import nl.gelton.projectnbackend.dto.output.AddressOutputDto;
import nl.gelton.projectnbackend.model.Address;

public class AddressMapper {

    public static Address fromInputDtoToModel(AddressInputDto addressInputDto) {
        Address address = new Address();
        address.setStreet(addressInputDto.getStreet());
        address.setZipCode(addressInputDto.getZipCode());
        address.setCity(addressInputDto.getCity());
        address.setCountry(addressInputDto.getCountry());
        return address;
    }

    public static AddressOutputDto fromModelToOutputDto(Address address) {
        AddressOutputDto addressOutputDto = new AddressOutputDto();
        addressOutputDto.setId(address.getId());
        addressOutputDto.setStreet(address.getStreet());
        addressOutputDto.setZipCode(address.getZipCode());
        addressOutputDto.setCity(address.getCity());
        addressOutputDto.setCountry(address.getCountry());
        return addressOutputDto;
    }

}
