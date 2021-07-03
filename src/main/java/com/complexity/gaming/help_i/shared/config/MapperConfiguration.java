package com.complexity.gaming.help_i.shared.config;

import com.complexity.gaming.help_i.games.application.transform.mapper.GameMapper;
import com.complexity.gaming.help_i.security.application.transform.mapper.PlayerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class MapperConfiguration {
    @Bean
    public PlayerMapper getPlayerMapper() {
        return new PlayerMapper();
    }
    @Bean
    public GameMapper getGameMapper() {return new GameMapper();}
}