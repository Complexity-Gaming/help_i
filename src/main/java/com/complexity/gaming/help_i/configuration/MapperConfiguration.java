package com.complexity.gaming.help_i.configuration;

import com.complexity.gaming.help_i.security.application.transform.mapper.PlayerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    public PlayerMapper getPlayerConverter() {
        return new PlayerMapper();
    }
}