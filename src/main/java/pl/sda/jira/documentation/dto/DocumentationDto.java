package pl.sda.jira.documentation.dto;

public class DocumentationDto {

    private long id;
    private long projectId;
    private String title;

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentationDto)) return false;

        DocumentationDto that = (DocumentationDto) o;

        if (getId() != that.getId()) return false;
        if (getProjectId() != that.getProjectId()) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (int) (getProjectId() ^ (getProjectId() >>> 32));
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
