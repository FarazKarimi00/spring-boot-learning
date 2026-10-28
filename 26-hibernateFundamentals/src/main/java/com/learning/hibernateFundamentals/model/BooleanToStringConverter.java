package com.learning.hibernateFundamentals.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToStringConverter
        implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null) {
            return null;
        }
        return attribute ? "Yes" : "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return  null;
        }
        return dbData.equals("Yes");
    }
}
