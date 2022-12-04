package ua.solyha.footballmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.solyha.footballmanager.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
