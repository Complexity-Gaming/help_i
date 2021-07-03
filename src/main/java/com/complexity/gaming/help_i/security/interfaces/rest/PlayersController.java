package com.complexity.gaming.help_i.security.interfaces.rest;

import com.complexity.gaming.help_i.security.application.transform.mapper.PlayerMapper;
import com.complexity.gaming.help_i.security.application.transform.resource.ExpertResource;
import com.complexity.gaming.help_i.security.domain.model.Player;
import com.complexity.gaming.help_i.security.domain.service.PlayerService;
import com.complexity.gaming.help_i.security.application.transform.resource.PlayerResource;
import com.complexity.gaming.help_i.security.application.transform.resource.SavePlayerResource;
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

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlayersController {
    @Autowired
    private PlayerMapper mapper;
    @Autowired
    private PlayerService playerService;
    @GetMapping("/players")
    public Page<PlayerResource> getAllPlayers(Pageable pageable){
        List<PlayerResource> players = playerService.getAllPlayers(pageable)
                .getContent().stream().map(p -> mapper.convertToResource(p))
                .collect(Collectors.toList());
        int playerCount = players.size();
        return new PageImpl<>(players, pageable, playerCount);
    }
    @GetMapping("/players/{id}")
    public PlayerResource getPlayerById(@PathVariable(name = "id") Long playerId){
        return mapper.convertToResource(playerService.getPlayerById(playerId));
    }
    @CrossOrigin
    @GetMapping("/players/email/{email}")
    public PlayerResource getExpertByEmail(@PathVariable(name = "email") String email){
        return mapper.convertToResource(playerService.getPlayerByEmail(email));
    }
    @PostMapping("/players/sign-up")
    public PlayerResource createPlayer(@Valid @RequestBody SavePlayerResource resource){
        return mapper.convertToResource(playerService.createPlayer(
                mapper.convertToEntity(resource)));
    }
    @PutMapping("/players/{id}")
    public PlayerResource updatePlayer(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SavePlayerResource resource){
        return mapper.convertToResource(playerService.updatePlayer(
        playerId, mapper.convertToEntity(resource)));
    }
    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long playerId){
        return playerService.deletePlayer(playerId);
    }
}
