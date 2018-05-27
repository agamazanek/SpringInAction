package pl.sda.jira.documentation.domain;

import pl.sda.jira.documentation.dto.DocumentationDto;

public class Documentation {



    private Long id;
    private Long projectId;
    private String title;

    public Documentation(long id) {

        this.id = id;
    }

    public DocumentationDto asDto() {

        DocumentationDto documentationDto = new DocumentationDto();
        documentationDto.setId(id);
        return documentationDto;
    }

    public Long getId() {
        return id;
    }
}
