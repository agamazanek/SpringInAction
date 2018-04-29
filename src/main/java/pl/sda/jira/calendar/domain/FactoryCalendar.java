package pl.sda.jira.calendar.domain;

public class FactoryCalendar {

    public Calendar newEmptyCalendar(String name) {
        return new Calendar(name);
    }

    public Calendar newCalendarWithWeek(String name, int week) {
        Calendar calendar = newEmptyCalendar(name);
        calendar.setWeekStart(week);
        return calendar;
    }

}
