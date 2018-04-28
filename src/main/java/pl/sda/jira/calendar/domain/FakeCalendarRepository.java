package pl.sda.jira.calendar.domain;

public class FakeCalendarRepository implements CalendarRepository {
    private boolean somethingAdded = false;

    public void add(Calendar calendar) {
        somethingAdded = true;
    }

    public boolean existsFor(String personId) {
        return somethingAdded;
    }
}
