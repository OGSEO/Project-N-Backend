package nl.gelton.projectnbackend.repository;

import nl.gelton.projectnbackend.model.PoliticalParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
    PoliticalParty findByUserId(Long userId);
}
