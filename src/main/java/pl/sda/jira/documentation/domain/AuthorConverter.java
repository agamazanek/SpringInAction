package pl.sda.jira.documentation.domain;

import javax.persistence.AttributeConverter;

public class AuthorConverter implements AttributeConverter<Author , String> {

    private static final String DELIMITER = ";";

    @Override
    public String convertToDatabaseColumn(Author author) {
        return author.getName()+ DELIMITER + author.getLastName();
    }

    @Override
    public Author convertToEntityAttribute(String fullName) {
        final String[] split = fullName.split(DELIMITER);
        return new Author(split[0] , split[1]);


    }
}
