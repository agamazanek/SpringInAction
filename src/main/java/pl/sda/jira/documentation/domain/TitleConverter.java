package pl.sda.jira.documentation.domain;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TitleConverter implements AttributeConverter<Title , String> {
    @Override
    public String convertToDatabaseColumn(Title title) {
        return title.getName();
    }

    @Override
    public Title convertToEntityAttribute(String title) {
        return new Title(title);
    }
}
