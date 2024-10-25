package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.PoliticalPartyInputDto;

public interface PoliticalPartyService {

    Response createPoliticalParty(PoliticalPartyInputDto politicalPartyInputDto);

    Response getAllPoliticalParties();

//    Response getPoliticalPartyById(Long politicalPartyId);


//    Response updatePoliticalParty(Long politicalPartyId, PoliticalPartyInputDto politicalPartyInputDto);
//
//    Response deletePoliticalParty(Long politicalPartyId);

}
