package com.complexity.gaming.help_i.controller.security;

import com.complexity.gaming.help_i.domain.model.security.Player;
import com.complexity.gaming.help_i.domain.service.security.PlayerService;
import com.complexity.gaming.help_i.resource.security.PlayerResource;
import com.complexity.gaming.help_i.resource.security.SavePlayerResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlayersController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public Page<PlayerResource> getAllPlayers(Pageable pageable){
        List<PlayerResource> players = playerService.getAllPlayers(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int playerCount = players.size();
        return new PageImpl<>(players, pageable, playerCount);
    }

    @GetMapping("/players/{id}")
    public PlayerResource getPlayerById(@PathVariable(name = "id") Long playerId){
        return convertToResource(playerService.getPlayerById(playerId));
    }

    @PostMapping("/players")
    public PlayerResource createPlayer(@Valid @RequestBody SavePlayerResource resource){
        return convertToResource(playerService.createPlayer(
        convertToEntity(resource)));
    }

    @PutMapping("/players/{id}")
    public PlayerResource updatePlayer(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SavePlayerResource resource){
        return convertToResource(playerService.updatePlayer(
        playerId, convertToEntity(resource)));
    }

    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long playerId){
        return playerService.deletePlayer(playerId);
    }

    private Player convertToEntity(SavePlayerResource resource){
        return mapper.map(resource, Player.class);}

    private PlayerResource convertToResource(Player entity){
        return mapper.map(entity, PlayerResource.class);
    }
}
