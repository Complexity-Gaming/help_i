package com.complexity.gaming.help_i.application.domain.model.converters;

import com.complexity.gaming.help_i.application.domain.model.valueobjects.ApplicationId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ApplicationIdAttributeConverter implements AttributeConverter<ApplicationId, String> {


    @Override
    public String convertToDatabaseColumn(ApplicationId applicationId) {
        return applicationId.toString();
    }

    @Override
    public ApplicationId convertToEntityAttribute(String s) {
        return new ApplicationId(s);
    }
}
