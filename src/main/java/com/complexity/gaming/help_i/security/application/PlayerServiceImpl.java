package com.complexity.gaming.help_i.security.application;

import com.complexity.gaming.help_i.security.domain.model.Player;
import com.complexity.gaming.help_i.security.domain.repository.ExpertRepository;
import com.complexity.gaming.help_i.security.domain.repository.PlayerRepository;
import com.complexity.gaming.help_i.security.domain.service.PlayerService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ExpertRepository expertRepository;
    @Override
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(()-> new ResourceNotFoundException("Player","Id",playerId));
    }

    @Override
    public Player createPlayer(Player player) {
        if(expertRepository.findByEmail(player.getEmail()).isPresent() || playerRepository.findByEmail(player.getEmail()).isPresent())
            throw new ResourceNotFoundException("Email has already been taken");
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Long playerId, Player playerDetails) {
        return playerRepository.findById(playerId).map(player -> {
            player.setName(playerDetails.getName());
            player.setEmail(playerDetails.getEmail());
            return playerRepository.save(player);
        }).orElseThrow(()-> new ResourceNotFoundException("Player","Id",playerId));
    }

    @Override
    public ResponseEntity<?> deletePlayer(Long playerId) {
        return playerRepository.findById(playerId).map(player -> {
            playerRepository.delete(player);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Player","Id",playerId));
    }

    @Override
    public Player getPlayerByEmail(String email) {
        return playerRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("Player","email",email));
    }
}
