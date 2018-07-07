package pl.sda.jira.calendar.domain.model;

import pl.sda.jira.calendar.domain.dto.CalendarDto;

import javax.persistence.*;

@Entity
public class Calendar {

    @Id
    @GeneratedValue private Long id;
    @Convert(converter = NameConverter.class)
    private Name name;

    @Embedded
    private  Owner owner;

    public Calendar(String name, Owner owner) {

        this.name = new Name(name);
        this.owner = owner;

    }

    public Calendar(Long id, String name, Owner owner) {
        this.id = id;
        this.name = new Name(name);
        this.owner = owner;
    }

    public Calendar() {
    }

    public Calendar(CalendarDto calendarDto) {
        this.name = new Name(calendarDto.getName());
        //this.owner = new Owner(calendarDto.getOwner());
    }

    public String getOwner() {
        return owner.value();
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

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public CalendarDto asDto() {
        return CalendarDto.Builder.aCalendar(name.value(), owner.value()).withOwner(owner.value()).build();
    }
}
