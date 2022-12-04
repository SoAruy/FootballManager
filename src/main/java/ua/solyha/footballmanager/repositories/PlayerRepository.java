package ua.solyha.footballmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.solyha.footballmanager.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
