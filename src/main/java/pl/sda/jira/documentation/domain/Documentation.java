package pl.sda.jira.documentation.domain;

public class Documentation {

    Long documentationId;
    String documentationName;
    int noOfPages;
    Long projectId;

    public Documentation(String documentationName, Long projectId){
        this.documentationName = documentationName;
        this.projectId = projectId;
    }

    public Long getDocumentationId() {
        return documentationId;
    }

    public void setDocumentationId(Long documentationId) {
        this.documentationId = documentationId;
    }

    public String getDocumentationName() {
        return documentationName;
    }

    public void setDocumentationName(String documentationName) {
        this.documentationName = documentationName;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
