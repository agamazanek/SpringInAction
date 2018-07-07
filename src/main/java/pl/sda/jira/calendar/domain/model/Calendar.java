package pl.sda.jira.calendar.domain.model;

import pl.sda.jira.calendar.domain.dto.CalendarDto;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calendar {

    @Id
    @GeneratedValue private Long id;
    @Convert(converter = NameConverter.class)
    private Name name;
    private  String owner;

    public Calendar(String name, String owner) {

        this.name = new Name(name);
        this.owner = owner;
    }

    public Calendar(Long id, String name, String owner) {
        this.id = id;
        this.name = new Name(name);
        this.owner = owner;
    }

    public Calendar() {
    }

    public Calendar(CalendarDto calendarDto) {
        this.name = new Name(calendarDto.getName());
        this.owner = calendarDto.getOwner();
    }

    public String getOwner() {
        return owner;
    }
    public Long getId() {
        return id;
    }


    public boolean hasSameNameAs(String name) {
        return this.name.value().equals(name);
    }

    public void changeName(String name) {
        this.name = new Name(name);
    }

    public CalendarDto asDto() {
        return CalendarDto.Builder.aCalendar(name.value(), owner).withOwner(owner).build();
    }
}
