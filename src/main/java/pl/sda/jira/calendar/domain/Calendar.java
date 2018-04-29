package pl.sda.jira.calendar.domain;

import java.util.List;

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
}
