package pl.sda.jira.calendar.domain;

import java.util.List;
import java.util.Objects;

public class Calendar {

    private final String calendarName;

    private int weekStart;
    private String event;
    private List personId;

    public Calendar(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setWeekStart(int weekStart) {
        this.weekStart = weekStart;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return weekStart == calendar.weekStart &&
                Objects.equals(calendarName, calendar.calendarName) &&
                Objects.equals(event, calendar.event) &&
                Objects.equals(personId, calendar.personId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(calendarName, weekStart, event, personId);
    }
}
