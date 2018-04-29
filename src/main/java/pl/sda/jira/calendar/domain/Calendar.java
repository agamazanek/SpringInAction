package pl.sda.jira.calendar.domain;

import java.util.List;

public class Calendar {

    private final String calendarName;

    private int weekStart;
    private List event;
    private List personId;

    public Calendar(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getCalendarName() {
        return calendarName;
    }
}
