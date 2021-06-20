package com.complexity.gaming.help_i;

import com.complexity.gaming.help_i.session.domain.model.IndividualSession;
import com.complexity.gaming.help_i.session.domain.repository.IndividualSessionRepository;
import com.complexity.gaming.help_i.session.domain.service.IndividualSessionService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import com.complexity.gaming.help_i.session.service.IndividualSessionServiceImpl;
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
public class IndividualSessionServiceImplTest {
    @MockBean
    private IndividualSessionRepository individualSessionRepository;

    @Autowired
    private IndividualSessionService individualSessionService;

    @TestConfiguration
    static  class IndividualSessionServiceImplTestConfiguration{
        @Bean
        public IndividualSessionService individualSessionService(){
            return new IndividualSessionServiceImpl();
        }
    }

    @Test
    @DisplayName("When getIndividualSessionById With Valid Id Then Return IndividualSession")
    public void whenGetIndividualSessionByIdWithValidIdThenReturnIndividualSession(){
        //Arrange
        Long id = 1L;
        IndividualSession individualSession = new IndividualSession();
        individualSession.setId(id);
        when(individualSessionRepository.findById(id))
                .thenReturn(Optional.of(individualSession));
        //Act
        IndividualSession foundIndividualSession = individualSessionService.getIndividualSessionById(id);
        //Assert
        assertThat(foundIndividualSession.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getIndividualSessionById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetIndividualSessionByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(individualSessionRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"session", "Id", id);
        //Act
        Throwable exception = catchThrowable(() -> {
            IndividualSession foundIndividualSession = individualSessionService.getIndividualSessionById(id);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
