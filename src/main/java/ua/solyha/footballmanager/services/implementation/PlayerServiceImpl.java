package ua.solyha.footballmanager.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.solyha.footballmanager.controllers.PlayerController;
import ua.solyha.footballmanager.controllers.TeamController;
import ua.solyha.footballmanager.dto.PlayerDto;
import ua.solyha.footballmanager.dto.PlayerListDto;
import ua.solyha.footballmanager.dto.TeamListDto;
import ua.solyha.footballmanager.entities.Player;
import ua.solyha.footballmanager.repositories.PlayerRepository;
import ua.solyha.footballmanager.services.PlayerService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }

    public List<PlayerListDto> findAll(){
        List<Player> players = playerRepository.findAll();
        List<PlayerListDto> playerListDtos = new ArrayList<>();

        for (Player player : players) {
            PlayerListDto playerListDto = modelMapper.map(player, PlayerListDto.class);
            Link selfLink = linkTo(methodOn(PlayerController.class)
                    .getPlayer(player.getId())).withRel("self");
            Link teamLink = linkTo(methodOn(TeamController.class)
                    .getTeam(player.getTeam().getId())).withRel("team");

            playerListDto.add(selfLink, teamLink);
            playerListDtos.add(playerListDto);
        }
        return playerListDtos;
    }

    public PlayerDto findById(int id){
        Player player = playerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        PlayerDto playerDto = modelMapper.map(player, PlayerDto.class);

        TeamListDto teamListDto = modelMapper.map(player.getTeam(), TeamListDto.class);
        Link teamLink = linkTo(methodOn(TeamController.class)
                .getTeam(player.getTeam().getId())).withRel("team");

        playerDto.add(teamLink);

        return playerDto;
    }

    @Transactional
    public void save(Player player){
        playerRepository.save(player);
    }

    @Transactional
    public void update(int id, Player updatedPlayer){
        updatedPlayer.setId(id);
        playerRepository.save(updatedPlayer);
    }

    @Transactional
    public void delete(int id){
        playerRepository.deleteById(id);
    }
}
