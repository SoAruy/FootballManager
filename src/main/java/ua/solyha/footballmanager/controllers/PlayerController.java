package ua.solyha.footballmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import ua.solyha.footballmanager.dto.PlayerDto;
import ua.solyha.footballmanager.dto.PlayerListDto;
import ua.solyha.footballmanager.entities.Player;
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
    public List<PlayerListDto> getPlayers(){
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public PlayerDto getPlayer(@PathVariable("id") int id){
        return playerService.findById(id);
    }
}
