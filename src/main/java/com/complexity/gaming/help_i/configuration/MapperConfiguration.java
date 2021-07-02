package com.complexity.gaming.help_i.configuration;

import com.complexity.gaming.help_i.games.application.transform.mapper.GameMapper;
import com.complexity.gaming.help_i.security.application.transform.mapper.PlayerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    public PlayerMapper getPlayerMapper() {
        return new PlayerMapper();
    }
    @Bean
    public GameMapper getGameMapper() {return new GameMapper();}
}
