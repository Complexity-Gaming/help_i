package com.complexity.gaming.help_i;

import com.complexity.gaming.help_i.domain.model.Security.Player;
import com.complexity.gaming.help_i.domain.repository.Security.PlayerRepository;
import com.complexity.gaming.help_i.domain.service.Security.PlayerService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import com.complexity.gaming.help_i.service.Security.PlayerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class PlayerServiceImplTest {

    @MockBean
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerService playerService;

    @TestConfiguration
    static  class PlayerServiceImplTestConfiguration{
        @Bean
        public  PlayerService playerService(){
            return new PlayerServiceImpl();
        }
    }

    @Test
    @DisplayName("When getPlayerById With Valid Id Then Return Player")
    public void whenGetPlayerByIdWithValidIdThenReturnPlayer(){
        //Arrange
        Long id = 1L;
        Player player = new Player();
        player.setId(id);
        when(playerRepository.findById(id))
                .thenReturn(Optional.of(player));
        //Act
        Player foundPlayer = playerService.getPlayerById(id);
        //Assert
        assertThat(foundPlayer.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getPlayerById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetPlayerByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(playerRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"Player", "Id", id);
        //Act
        Throwable exception = catchThrowable(() -> {
            Player foundPlayer = playerService.getPlayerById(id);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}