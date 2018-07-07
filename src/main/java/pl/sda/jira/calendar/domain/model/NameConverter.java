package pl.sda.jira.calendar.domain.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class NameConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name name) {
        return name.value();
    }

    @Override
    public Name convertToEntityAttribute(String value) {
        return new Name(value);
    }
}
