package com.complexity.gaming.help_i;

import com.complexity.gaming.help_i.domain.model.Application.ExpertApplication;
import com.complexity.gaming.help_i.domain.repository.Application.ExpertApplicationRepository;
import com.complexity.gaming.help_i.domain.repository.Security.ExpertRepository;
import com.complexity.gaming.help_i.domain.repository.Security.PlayerRepository;
import com.complexity.gaming.help_i.domain.service.Application.ExpertApplicationService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import com.complexity.gaming.help_i.service.Application.ExpertApplicationServiceImpl;
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
public class ExpertApplicationServiceImplTest {

    @MockBean
    private ExpertApplicationRepository expertApplicationRepository;

    @MockBean
    private PlayerRepository playerRepository;

    @MockBean
    private ExpertRepository expertRepository;

    @Autowired
    private ExpertApplicationService expertApplicationService;


    @TestConfiguration
    static  class ExpertApplicationServiceImplTestConfiguration{
        @Bean
        public  ExpertApplicationService expertApplicationService(){
            return new ExpertApplicationServiceImpl();
        }
    }

    @Test
    @DisplayName("When getExpertApplicationById With Valid Id Then Return ExpertApplication")
    public void whenGetExpertApplicationByIdWithValidIdThenReturnExpertApplication(){
        //Arrange
        Long id = 1L;
        ExpertApplication expertApplication = new ExpertApplication();
        expertApplication.setId(id);
        when(expertApplicationRepository.findById(id))
                .thenReturn(Optional.of(expertApplication));
        //Act
        ExpertApplication foundExpertApplication = expertApplicationService.getExpertApplicationById(id);
        //Assert
        assertThat(foundExpertApplication.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getExpertApplicationById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetExpertApplicationByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(expertApplicationRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"Application", "Id", id);
        //Act
        Throwable exception = catchThrowable(() -> {
            ExpertApplication foundExpertApplication = expertApplicationService.getExpertApplicationById(id);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
