package nl.gelton.projectnbackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.PoliticalPartyInputDto;
import nl.gelton.projectnbackend.dto.mapper.PoliticalPartyMapper;
import nl.gelton.projectnbackend.dto.output.PoliticalPartyOutputDto;
import nl.gelton.projectnbackend.model.PoliticalParty;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.PoliticalPartyRepository;
import nl.gelton.projectnbackend.service.PoliticalPartyService;
import nl.gelton.projectnbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class PoliticalPartyImpl implements PoliticalPartyService {

    private final PoliticalPartyRepository politicalPartyRepository;
    private final UserService userService;

    @Override
    public Response createPoliticalParty(PoliticalPartyInputDto politicalPartyInputDto) {
        User user = userService.getLoggedUser();
        PoliticalParty politicalParty = PoliticalPartyMapper.fromInputDtoToModel(politicalPartyInputDto);
        politicalParty.setUser(user);
        politicalParty.setCreatedAt(LocalDateTime.now());
        politicalPartyRepository.save(politicalParty);

        return Response.builder()
                .statusCode(200)
                .statusMessage("Political Party Created Successfully")
                .party(PoliticalPartyMapper.fromModelToOutputDto(politicalParty))
                .build();
    }

    @Override
    public Response getAllPoliticalParties() {
        List<PoliticalParty> politicalParties = politicalPartyRepository.findAll();
        List<PoliticalPartyOutputDto> politicalPartyOutputDtos = new ArrayList<>();

        for (PoliticalParty politicalParty : politicalParties) {
            politicalPartyOutputDtos.add(PoliticalPartyMapper.fromModelToOutputDto(politicalParty));
        }

        return Response.builder()
                .statusCode(200)
                .statusMessage("Political Parties Found Successfully")
                .partyList(politicalPartyOutputDtos)
                .build();
    }

//    @Override
//    public Response getPoliticalPartyById(Long politicalPartyId) {
//        PoliticalParty politicalParty = politicalPartyRepository.findById(politicalPartyId).orElseThrow(()-> new RecordNotFoundException("Political Party Not Found"));
//        PoliticalPartyOutputDto politicalPartyOutputDto = PoliticalPartyMapper.fromModelToOutputDto(politicalParty);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Political Party Found Successfully")
//                .party(politicalPartyOutputDto)
//                .build();
//    }


//    @Override
//    public Response updatePoliticalParty(Long politicalPartyId, PoliticalPartyInputDto politicalPartyInputDto) {
//        PoliticalParty politicalParty = politicalPartyRepository.findById(politicalPartyId).orElseThrow(()-> new RecordNotFoundException("Political Party Not Found!"));
//        politicalParty.setName(politicalPartyInputDto.getName());
//        politicalParty.setDescription(politicalPartyInputDto.getDescription());
//        politicalPartyRepository.save(politicalParty);
//
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Political Party Updated Successfully")
//                .party(PoliticalPartyMapper.fromModelToOutputDto(politicalParty))
//                .build();
//    }
//
//    @Override
//    public Response deletePoliticalParty(Long politicalPartyId) {
//        PoliticalParty politicalParty = politicalPartyRepository.findById(politicalPartyId).orElseThrow(()-> new RecordNotFoundException("Political Party Not Found!"));
//        politicalPartyRepository.delete(politicalParty);
//        return Response.builder()
//                .statusCode(200)
//                .statusMessage("Political Party Deleted Successfully")
//                .build();
//    }
}
