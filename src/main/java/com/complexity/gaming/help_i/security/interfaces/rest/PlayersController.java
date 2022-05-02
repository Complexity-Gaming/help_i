package com.complexity.gaming.help_i.security.interfaces.rest;

import com.complexity.gaming.help_i.security.application.transform.mapper.PlayerMapper;
import com.complexity.gaming.help_i.security.domain.service.PlayerService;
import com.complexity.gaming.help_i.security.application.transform.resource.PlayerResource;
import com.complexity.gaming.help_i.security.application.transform.resource.SavePlayerResource;

import com.sun.xml.bind.v2.TODO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @Operation(summary = "Get all players", description = "Get all players", tags = {"players"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/players")
    public Page<PlayerResource> getAllPlayers(Pageable pageable){
        List<PlayerResource> players = playerService.getAllPlayers(pageable)
                .getContent().stream().map(p -> mapper.convertToResource(p))
                .collect(Collectors.toList());
        int playerCount = players.size();
        return new PageImpl<>(players, pageable, playerCount);
    }
    @Operation(summary = "Get all players by Id", description = "Get all players by Id", tags = {"players"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/players/{id}")
    public PlayerResource getPlayerById(@PathVariable(name = "id") Long playerId){
        return mapper.convertToResource(playerService.getPlayerById(playerId));
    }

    @Operation(summary = "Get all players by email", description = "Get all players by email", tags = {"players"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/players/email/{email}")
    public PlayerResource getExpertByEmail(@PathVariable(name = "email") String email){
        //TODO: Correct this Expert?
        return mapper.convertToResource(playerService.getPlayerByEmail(email));
    }
    @Operation(summary = "Create a new player", description = "Create a new player", tags = {"players"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/players/sign-up")
    public PlayerResource createPlayer(@Valid @RequestBody SavePlayerResource resource){
        return mapper.convertToResource(playerService.createPlayer(
                mapper.convertToEntity(resource)));
    }
    @Operation(summary = "Update a player", description = "Update a player", tags = {"players"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/players/{id}")
    public PlayerResource updatePlayer(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SavePlayerResource resource){
        return mapper.convertToResource(playerService.updatePlayer(
        playerId, mapper.convertToEntity(resource)));
    }
    @Operation(summary = "Delete a player", description = "Delete a player", tags = {"players"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long playerId){
        return playerService.deletePlayer(playerId);
    }
}
