package nl.gelton.projectnbackend.dto.mapper;

import nl.gelton.projectnbackend.dto.input.PoliticalPartyInputDto;
import nl.gelton.projectnbackend.dto.output.PoliticalPartyOutputDto;
import nl.gelton.projectnbackend.model.PoliticalParty;

public class PoliticalPartyMapper {

    public static PoliticalParty fromInputDtoToModel(PoliticalPartyInputDto politicalPartyInputDto) {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName(politicalPartyInputDto.getName());
        politicalParty.setDescription(politicalPartyInputDto.getDescription());
        return politicalParty;
    }

    public static PoliticalPartyOutputDto fromModelToOutputDto(PoliticalParty politicalParty) {
        PoliticalPartyOutputDto politicalPartyOutputDto = new PoliticalPartyOutputDto();
        politicalPartyOutputDto.setId(politicalParty.getId());
        politicalPartyOutputDto.setName(politicalParty.getName());
        politicalPartyOutputDto.setDescription(politicalParty.getDescription());
        politicalPartyOutputDto.setCreatedAt(politicalParty.getCreatedAt());
        politicalPartyOutputDto.setUser(UserMapper.fromModelToOutputDto(politicalParty.getUser()).getName()); //eeddiitt
        return politicalPartyOutputDto;
    }
}
