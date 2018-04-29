package pl.sda.jira.calendar.domain;

public class Calendar {
    private String[] personIds;
    private final String name;
    private String weekStart;
    private String[] event;

    public Calendar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeekStart(String weekStart) {
        this.weekStart = weekStart;
    }

    public void setEvent(String[] event) {
        this.event = event;
    }
}
