package com.complexity.gaming.help_i;

import com.complexity.gaming.help_i.domain.model.Session.ScheduledSession;
import com.complexity.gaming.help_i.domain.repository.Security.ExpertRepository;
import com.complexity.gaming.help_i.domain.repository.Security.PlayerRepository;
import com.complexity.gaming.help_i.domain.repository.Session.ScheduledSessionRepository;
import com.complexity.gaming.help_i.domain.service.Session.ScheduledSessionService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import com.complexity.gaming.help_i.service.Session.ScheduledSessionServiceImpl;
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
public class ScheduledSessionServiceImplTest {
    @MockBean
    private ScheduledSessionRepository scheduledSessionRepository;

    @MockBean
    private ExpertRepository expertRepository;

    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private ScheduledSessionService scheduledSessionService;

    @TestConfiguration
    static  class ScheduledSessionServiceImplTestConfiguration{
        @Bean
        public ScheduledSessionService scheduledSessionService(){
            return new ScheduledSessionServiceImpl();
        }
    }

    @Test
    @DisplayName("When getScheduledSessionById With Valid Id Then Return ScheduledSession")
    public void whenGetScheduledSessionByIdIdWithValidIdThenReturnScheduledSession(){
        //Arrange
        Long id = 1L;
        ScheduledSession scheduledSession = new ScheduledSession();
        scheduledSession.setId(id);
        when(scheduledSessionRepository.findById(id))
                .thenReturn(Optional.of(scheduledSession));
        //Act
        ScheduledSession foundScheduledSession = scheduledSessionService.getScheduledSessionById(id);
        //Assert
        assertThat(foundScheduledSession.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getScheduledSessionById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetScheduledSessionByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(scheduledSessionRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"Scheduled", "Id", id);
        //Act
        Throwable exception = catchThrowable(() -> {
            ScheduledSession foundScheduledSession = scheduledSessionService.getScheduledSessionById(id);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
