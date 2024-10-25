package nl.gelton.projectnbackend.repository;

import nl.gelton.projectnbackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
