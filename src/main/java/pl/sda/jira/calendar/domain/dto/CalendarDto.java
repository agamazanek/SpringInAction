package pl.sda.jira.calendar.domain.dto;

public class CalendarDto {
    public final String name;

    public CalendarDto(String name) {
        this.name = name;
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
            return new CalendarDto(name);
        }
    }
}
