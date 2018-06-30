package pl.sda.jira.calendar.domain.model;

import pl.sda.jira.calendar.domain.dto.CalendarDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calendar {
    @Id
    @GeneratedValue
    private String id;
    private String name;

    private String owner;

    private  String event;

    public Calendar(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Calendar() {
    }

    public Calendar(CalendarDto calendarDto) {
        this.name = calendarDto.getName();
    }

    public Calendar(String id, String name, String owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public Calendar(String id, String name, String owner, String event) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.event = event;
    }


    public String getId() {
        return id;
    }

    public boolean hasSameNameAs(String name) {
        return this.name.equals(name);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public CalendarDto asDto() {
        return CalendarDto.Builder.aCalendar(name).withId(id).build();
    }
    public String getOwner() {
        return owner;
    }

    public String getEvent() {
        return event;
    }


}
