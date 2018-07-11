package pl.sda.jira.calendar.domain.dto;
import pl.sda.jira.calendar.domain.model.Owner;

public class CalendarDto {
    private String name;
    private Owner owner;

    public CalendarDto() {}

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public Owner getOwner() {
        return owner;
    }


    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public CalendarDto(Builder builder) {
        this.name = builder.name;
        this.owner = builder.owner;
    }


    public static class Builder {
        private String name;
        private Owner owner;


        private Builder(String name, Owner owner) {
            this.name = name;
            this.owner = owner;
        }

        public static Builder buildACalendar(String name, Owner owner) {
            return new Builder(name, owner);
        }


        public CalendarDto build() {
            return new CalendarDto(this);
        }

        public Builder withOwner(Owner owner) {
            this.owner = owner;
            return this;
        }
    }
}
