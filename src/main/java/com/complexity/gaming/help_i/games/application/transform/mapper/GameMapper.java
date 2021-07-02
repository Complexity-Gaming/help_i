package com.complexity.gaming.help_i.games.application.transform.mapper;

import com.complexity.gaming.help_i.games.application.transform.resource.GameResource;
import com.complexity.gaming.help_i.games.domain.model.aggregate.Game;

public class GameMapper {
    public GameResource convertToResource(Game entity) {
        return new GameResource()
                .setId(entity.getId())
                .setProviderId(entity.getProviderId())
                .setName(entity.getName())
                .setProviderName(entity.getProviderInformation().getProviderName())
                .setCoverUrl(entity.getProviderInformation().getCoverUrl())
                .setCoverHeight(entity.getProviderInformation().getCoverHeight())
                .setCoverWidth(entity.getProviderInformation().getCoverWidth())
                .setStoryLine(entity.getProviderInformation().getStoryLine())
                .setSummary(entity.getProviderInformation().getSummary())
                .setBackgroundImageUrl(entity.getProviderInformation().getBackgroundImageUrl())
                .setBackgroundHeight(entity.getProviderInformation().getBackgroundHeight())
                .setBackgroundWidth(entity.getProviderInformation().getBackgroundWidth());
    }
}
