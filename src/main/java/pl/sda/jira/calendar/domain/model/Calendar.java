package pl.sda.jira.calendar.domain.model;

public class Calendar {
    private final String id;
    private String name;

    public Calendar(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public boolean hasSameNameAs(String name) {
        return this.name.equals(name);
    }

    public void changeName(String name) {
        this.name = name;
    }
}
