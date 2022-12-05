package ua.solyha.footballmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import ua.solyha.footballmanager.dto.TeamDto;
import ua.solyha.footballmanager.dto.TeamListDto;
import ua.solyha.footballmanager.dto.TeamUpdateDto;
import ua.solyha.footballmanager.entities.Team;
import static org.springframework.http.MediaType.*;
import ua.solyha.footballmanager.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamListDto> getTeams(){
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamDto getTeam(@PathVariable("id") int id){
        return teamService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable("id") int id){
        teamService.delete(id);
        return "Successfully deleted";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto create(@RequestBody TeamUpdateDto teamUpdateDto){
        return teamService.save(teamUpdateDto);
    }

    @PutMapping("/{id}")
    public TeamDto update(@PathVariable("id") int id, @RequestBody TeamUpdateDto teamUpdateDto){
        return teamService.update(id, teamUpdateDto);
    }
}
