package pl.sda.jira.documentation.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

public class Title {
    private String title;

    public Title(String title) {
        this.title = title;
    }

    public String getName() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }

}
