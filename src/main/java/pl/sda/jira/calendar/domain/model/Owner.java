package pl.sda.jira.calendar.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Owner {

    @Column(name = "first_name")
    private String name;
    private String lastName;
    private String department;


    public Owner(String name, String lastName, String department) {
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    private Owner(){}


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String value(){
        return name + " " + lastName + " " + department;
    }
}


