package pl.sda.jira.calendar.queries;

public class QueryCriteriaDto {

   private  String name;
   private String type;
   private  Object value;

    public QueryCriteriaDto(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    private QueryCriteriaDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }


    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QueryCriteriaDto{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
