package ua.solyha.footballmanager.services;

import ua.solyha.footballmanager.dto.PlayerDto;
import ua.solyha.footballmanager.dto.PlayerListDto;
import ua.solyha.footballmanager.entities.Player;

import java.util.List;

public interface PlayerService {
    List<PlayerListDto> findAll();

    PlayerDto findById(int id);

    void save(Player player);

    void update(int id, Player updatedPlayer);

    void delete(int id);

    PlayerDto transferPlayer(int id, int teamId);
}
