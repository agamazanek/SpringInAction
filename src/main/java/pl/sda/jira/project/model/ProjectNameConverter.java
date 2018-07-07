package pl.sda.jira.project.model;

import javax.persistence.AttributeConverter;

public class ProjectNameConverter implements AttributeConverter<ProjectName,String>{

    @Override
    public String convertToDatabaseColumn(ProjectName name) {
        return name.getName();
    }

    @Override
    public ProjectName convertToEntityAttribute(String name) {
        return new ProjectName(name);
    }
}
