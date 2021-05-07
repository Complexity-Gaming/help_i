package com.complexity.gaming.help_i.domain.service;

import com.complexity.gaming.help_i.domain.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PlayerService {

    Page<Player> getAllPlayers(Pageable pageable);
    Player getPlayerById(Long playerId);
    Player createPlayer(Player player);
    Player updatePlayer(Long playerId, Player playerDetails);
    ResponseEntity<?> deletePlayer(Long playerId);
}
