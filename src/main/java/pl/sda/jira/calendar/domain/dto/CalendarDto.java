package pl.sda.jira.calendar.domain.dto;


import pl.sda.jira.calendar.domain.model.Name;
import pl.sda.jira.calendar.domain.model.Owner;

public class CalendarDto {
//    private String name;
//    private String owner;
    private Name name;
    private Owner owner;

    public CalendarDto() {}

//    public void setName(String name) {
//        this.name = name;
//    }
    public void setName(Name name){
        this.name = name;
    }

//    public String getName() {
//        return name;
//    }
    public Name getName(){
        return name;
    }

//    public String getOwner() {
//        return owner;
//    }


    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner(){
        return owner;
    }

    public CalendarDto(Builder builder) {
//        this.name = builder.name;
//        this.owner = builder.owner;
        this.name = builder.calendarName;
        this.owner = builder.calendarOwner;
    }

//    public boolean hasSameNameAs(String name) {
//        return this.name.equals(name);
//    }

    public boolean hasSameName(Name name){
        return this.name.equals(name);
    }

    public boolean hasSameNameAs(Name calendarName) {
        return this.name.equals(calendarName);
    }


    public static class Builder {
        //private final String name;
        //private String owner;
        private Name calendarName;
        private Owner calendarOwner;



//        private Builder(String name, String owner) {
//            this.name = name;
//            this.owner = owner;
//        }

        private Builder (Name calendarName, Owner calendarOwner){
            this.calendarName = calendarName;
            this.calendarOwner = calendarOwner;
        }


//        public static Builder aCalendar(String name, String owner) {
//            return new Builder(name, owner);
//        }
        public static Builder buildACalendar(Name calendarName, Owner calendarOwner){
            return new Builder(calendarName, calendarOwner);
        }

        public CalendarDto build() {
            return new CalendarDto(this);
        }

//        public Builder withId(String id) {
//            this.id = id;
//            return this;
//        }

//        public Builder withOwner(String owner) {
//            this.owner = owner;
//            return this;
//        }

        public Builder withOwner(Owner owner){
            this.calendarOwner = owner;
            return this;
        }
    }
}
