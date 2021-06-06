package com.complexity.gaming.help_i.domain.model.training.converters;

import com.complexity.gaming.help_i.domain.model.training.TrainingId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TrainingIdAttributeConverter implements AttributeConverter<TrainingId, String>{


    @Override
    public String convertToDatabaseColumn(TrainingId trainingId) {
        return trainingId.toString();
    }

    @Override
    public TrainingId convertToEntityAttribute(String s) {
        return new TrainingId(s);
    }
}