package ua.solyha.footballmanager.services;

import ua.solyha.footballmanager.dto.PlayerDto;
import ua.solyha.footballmanager.dto.PlayerListDto;
import ua.solyha.footballmanager.dto.PlayerUpdateDto;
import ua.solyha.footballmanager.entities.Player;

import java.util.List;

public interface PlayerService {
    List<PlayerListDto> findAll();

    PlayerDto findById(int id);

    PlayerDto save(PlayerUpdateDto player);

    PlayerDto update(int id, PlayerUpdateDto updatedPlayer);

    void delete(int id);

    PlayerDto transferPlayer(int id, int teamId);
}
