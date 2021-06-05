package com.complexity.gaming.help_i.domain.model.Session.converters;

import com.complexity.gaming.help_i.domain.model.Session.ScheSessionId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ScheSessionIdAttributeConverter implements AttributeConverter<ScheSessionId, String> {

    @Override
    public String convertToDatabaseColumn(ScheSessionId scheSessionId) {
        return scheSessionId.toString();
    }

    @Override
    public ScheSessionId convertToEntityAttribute(String s) {
        return new ScheSessionId(s);
    }
}
