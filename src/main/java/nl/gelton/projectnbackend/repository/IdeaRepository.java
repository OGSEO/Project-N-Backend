package nl.gelton.projectnbackend.repository;

import nl.gelton.projectnbackend.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
    List<Idea> findByUserId(Long userId);
}
