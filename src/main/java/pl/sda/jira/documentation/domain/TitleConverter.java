package pl.sda.jira.documentation.domain;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TitleConverter implements AttributeConverter<Title , String> {
    @Override
    public String convertToDatabaseColumn(Title title) {
        if(title == null){
            return null;
        }
        return title.getName();
    }

    @Override
    public Title convertToEntityAttribute(String title) {
       if(title == null){
           return null;
       }
        return new Title(title);
    }
}
