package com.complexity.gaming.help_i;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;
import com.complexity.gaming.help_i.security.domain.repository.ExpertRepository;
import com.complexity.gaming.help_i.security.domain.repository.PlayerRepository;
import com.complexity.gaming.help_i.training.domain.repository.TrainingMaterialRepository;
import com.complexity.gaming.help_i.training.domain.service.TrainingMaterialService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import com.complexity.gaming.help_i.training.service.TrainingMaterialServiceImpl;
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
public class TrainingMaterialServiceImplTest {

    @MockBean
    private TrainingMaterialRepository trainingMaterialRepository;

    @MockBean
    private ExpertRepository expertRepository;

    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private TrainingMaterialService trainingMaterialService;

    @TestConfiguration
    static  class TrainingMaterialServiceImplTestConfiguration{
        @Bean
        public  TrainingMaterialService trainingMaterialService(){
            return new TrainingMaterialServiceImpl();
        }
    }

    @Test
    @DisplayName("When getTrainingMaterialById With Valid Id Then Return TrainingMaterial")
    public void whenGetTrainingMaterialByIdWithValidIdThenReturnTrainingMaterial(){
        //Arrange
        Long id = 1L;
        TrainingMaterial trainingMaterial = new TrainingMaterial();
        trainingMaterial.setId(id);
        when(trainingMaterialRepository.findById(id))
                .thenReturn(Optional.of(trainingMaterial));
        //Act
        TrainingMaterial foundTrainingMaterial = trainingMaterialService.getTrainingMaterialById(id);
        //Assert
        assertThat(foundTrainingMaterial.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getTrainingMaterialById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetTrainingMaterialByIdWithInvalidIdThenReturnsResourceNotFoundException(){
        //Arrange
        Long id = 1L;
        String template = "Resource %s not found for %s with value %s";
        when(trainingMaterialRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"training", "Id", id);
        //Act
        Throwable exception = catchThrowable(() -> {
            TrainingMaterial foundTrainingMaterial = trainingMaterialService.getTrainingMaterialById(id);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
