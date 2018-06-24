package pl.sda.jira.documentation.dto;

public class DocumentationDto {
    private Long id;
    private String title;


    public DocumentationDto(String title) {

        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

}
