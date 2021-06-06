package com.complexity.gaming.help_i;

import com.complexity.gaming.help_i.domain.model.security.Expert;
import com.complexity.gaming.help_i.domain.repository.security.ExpertRepository;
import com.complexity.gaming.help_i.domain.service.security.ExpertService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import com.complexity.gaming.help_i.service.security.ExpertServiceImpl;
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
public class ExpertServiceImplTest {

    @MockBean
    private ExpertRepository expertRepository;
    @Autowired
    private ExpertService expertService;

    @TestConfiguration
    static  class ExpertServiceImplTestConfiguration{
        @Bean
        public  ExpertService expertService(){
            return new ExpertServiceImpl();
        }
    }

    @Test
    @DisplayName("When getExpertById With Valid Id Then Return Expert")
    public void whenGetExpertByIdWithValidIdThenReturnExpert(){
        //Arrange
        Long id = 1L;
        Expert expert = new Expert();
        expert.setId(id);
        when(expertRepository.findById(id))
                .thenReturn(Optional.of(expert));
        //Act
        Expert foundExpert = expertService.getExpertById(id);
        //Assert
        assertThat(foundExpert.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getExpertById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetExpertByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(expertRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"Expert", "Id", id);
        //Act
        Throwable exception = catchThrowable(() -> {
            Expert foundExpert = expertService.getExpertById(id);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
