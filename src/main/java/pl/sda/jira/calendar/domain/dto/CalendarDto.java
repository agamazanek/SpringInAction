package pl.sda.jira.calendar.domain.dto;


public class CalendarDto {
    private final String name;


    public String getName() {
        return name;
    }

    public CalendarDto(Builder builder) {
        this.name = builder.name;
    }

    public static class Builder {
        private final String name;


        private Builder(String name) {
            this.name = name;
        }


        public static Builder aCalendar(String name) {
            return new Builder(name);
        }

        public CalendarDto build() {
            return new CalendarDto(this);
        }
    }
}
