package pl.sda.jira.calendar.domain.dto;

public class CalendarDto {
    private String name;
    private String ownerName;
    private String ownerLastName;
    private String ownerDepartment;

    public CalendarDto() {}


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerDepartment() {
        return ownerDepartment;
    }

    public void setOwnerDepartment(String ownerDepartment) {
        this.ownerDepartment = ownerDepartment;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



    public CalendarDto(Builder builder) {
        this.name = builder.name;
        this.ownerName = builder.ownerName;
        this.ownerLastName = builder.ownerLastName;
        this.ownerDepartment = builder.ownerDepartment;
    }


    public static class Builder {
        private String name;
        private String ownerName;
        private String ownerLastName;
        private String ownerDepartment;


        private Builder(String name) {
            this.name = name;
        }


        public static Builder buildACalendar(String name) {

            return new Builder(name);
        }

        public CalendarDto build() {
            return new CalendarDto(this);
        }

        public Builder withOwner(String ownerName, String ownerLastName, String ownerDepartment) {
            this.ownerName = ownerName;
            this.ownerLastName = ownerLastName;
            this.ownerDepartment = ownerDepartment;
            return this;
        }
    }
}
