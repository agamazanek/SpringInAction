package pl.sda.jira.project.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectManager {

    @Column(name = "manager_name")
    private String name;
    @Column(name = "manager_last_name")
    private String lastName;
    @Column(name = "manager_department")
    private String department;

    private ProjectManager() {
    }

    public ProjectManager(String name, String lastName, String department) {
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }


    public String value() {
        return name + ' ' + lastName + ' ' + department;
    }
}



