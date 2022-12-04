package ua.solyha.footballmanager.services;

import ua.solyha.footballmanager.dto.TeamDto;
import ua.solyha.footballmanager.dto.TeamListDto;
import ua.solyha.footballmanager.dto.TeamUpdateDto;
import ua.solyha.footballmanager.entities.Team;

import java.util.List;

public interface TeamService {
    List<TeamListDto> findAll();

    TeamDto findById(int id);

    TeamDto save(TeamUpdateDto teamUpdateDto);

    TeamDto update(int id, TeamUpdateDto updatedTeam);

    void delete(int id);
}
