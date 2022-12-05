package ua.solyha.footballmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import ua.solyha.footballmanager.dto.*;
import ua.solyha.footballmanager.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerListDto> getPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public PlayerDto getPlayer(@PathVariable("id") int id) {
        return playerService.findById(id);
    }

    @PutMapping("/{id}/team/{team_id}")
    public PlayerDto transferPlayer(@PathVariable("id") int id, @PathVariable("team_id") int teamId) {
        return playerService.transferPlayer(id, teamId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        playerService.delete(id);
        return "Successfully deleted";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto create(@RequestBody PlayerUpdateDto playerUpdateDto){
        return playerService.save(playerUpdateDto);
    }

    @PutMapping("/{id}")
    public PlayerDto update(@RequestBody PlayerUpdateDto playerUpdateDto, @PathVariable("id") int id){
        return playerService.update(id, playerUpdateDto);
    }
}
