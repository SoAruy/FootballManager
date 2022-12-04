package ua.solyha.footballmanager.services;

import ua.solyha.footballmanager.dto.TeamDto;
import ua.solyha.footballmanager.dto.TeamListDto;
import ua.solyha.footballmanager.entities.Team;

import java.util.List;

public interface TeamService {
    List<TeamListDto> findAll();

    TeamDto findById(int id);

    void save(Team team);

    void update(int id, Team updatedTeam);

    void delete(int id);
}
