package pl.sda.jira;

public class TemplateDto {
    private String lastName;
    private String name;
    private String mail;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
}
