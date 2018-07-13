package pl.sda.jira.calendar.domain.model;

import javax.persistence.*;

@Entity
public class Owner {

    @Id @GeneratedValue
    private Long id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String value(){
        return name + " " + lastName + " " + department;
    }

}


