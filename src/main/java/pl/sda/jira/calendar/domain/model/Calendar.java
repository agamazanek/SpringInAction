package pl.sda.jira.calendar.domain.model;

import org.hibernate.annotations.Cascade;
import pl.sda.jira.calendar.domain.dto.CalendarDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.CascadeType.PERSIST;
import static org.hibernate.annotations.CascadeType.REMOVE;

@Entity
public class Calendar {

    @Id
    @GeneratedValue private Long id;
    @Convert(converter = NameConverter.class)
    private Name name;
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private  Owner owner;
    @OneToMany (fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Meeting> meetings = new ArrayList<>();

    private Calendar() {}

    public Calendar(String name, Owner owner) {

        this.name = new Name(name);
        this.owner = owner;
    }

    public Calendar(Long id, String name, Owner owner) {
        this.id = id;
        this.name = new Name(name);
        this.owner = owner;
    }

    public Calendar(CalendarDto calendarDto) {
        this.name = new Name(calendarDto.getName());
        this.owner = new Owner(calendarDto.getOwner().getName(), calendarDto.getOwner().getLastName(), calendarDto.getOwner().getDepartment());
    }

    public Calendar(Name name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }


    public String getOwner() {
        return owner.value();
    }
    public Long getId() {
        return id;
    }


//    public boolean hasSameNameAs(String name) {
//        return this.name.value().equals(name);
//    }
    public boolean hasSameNameAs(Name name){
        return this.name.equals(name);
    }

    public void changeName(String name) {
        this.name = new Name(name);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public CalendarDto asDto() {
        return CalendarDto.Builder.buildACalendar(name.value(), owner).withOwner(owner).build();
    }


    public boolean belongsTo(Owner owner) {
        if (this.owner == null) {
            return false;
        }

        return this.owner.getName().equals(owner.getName());
    }

    public void assignToOwner(Owner owner) {
        this.owner = owner;
    }

    public void addMeeting(Meeting meeting){
        this.meetings.add(meeting);
    }
}
