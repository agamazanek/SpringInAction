package pl.sda.jira.calendar.domain.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meeting {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String place;

    public Meeting(String title, String place) {
        this.title = title;
        this.place = place;
    }

    private Meeting(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;

        Meeting meeting = (Meeting) o;

        if (getId() != null ? !getId().equals(meeting.getId()) : meeting.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(meeting.getTitle()) : meeting.getTitle() != null) return false;
        return getPlace() != null ? getPlace().equals(meeting.getPlace()) : meeting.getPlace() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getPlace() != null ? getPlace().hashCode() : 0);
        return result;
    }
}
