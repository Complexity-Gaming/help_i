package com.complexity.gaming.help_i.security.application.transform.mapper;
import com.complexity.gaming.help_i.security.application.transform.resource.PlayerResource;
import com.complexity.gaming.help_i.security.application.transform.resource.SavePlayerResource;
import com.complexity.gaming.help_i.security.domain.model.Player;

public class PlayerMapper {

    public PlayerResource convertToResource(Player model) {
        return (PlayerResource) new PlayerResource()
                .setEmail(model.getEmail())
                .setName(model.getName())
                .setBirthDate(model.getBirthDate())
                .setId(model.getId())
                .setCreatedAt(model.getCreatedAt())
                .setUpdatedAt(model.getUpdatedAt());
    }

    public Player convertToEntity(SavePlayerResource resource) {
        return (Player) new Player()
                .setEmail(resource.getEmail())
                .setName(resource.getName())
                .setPassword(resource.getPassword())
                .setBirthDate(resource.getBirthDate());

    }
}
