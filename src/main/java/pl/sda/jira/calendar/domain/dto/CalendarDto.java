package pl.sda.jira.calendar.domain.dto;


public class CalendarDto {
    private String name;
    private String owner;

//    public String getId() {
//        return id;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public CalendarDto() {}

    public CalendarDto(Builder builder) {
        this.name = builder.name;
        this.owner = builder.owner;
    }


    public static class Builder {
        private final String name;
        private String owner;


        private Builder(String name, String owner) {
            this.name = name;
            this.owner = owner;
        }


        public static Builder aCalendar(String name, String owner) {
            return new Builder(name, owner);
        }

        public CalendarDto build() {
            return new CalendarDto(this);
        }

//        public Builder withId(String id) {
//            this.id = id;
//            return this;
//        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }
    }
}
