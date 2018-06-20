package pl.sda.jira;

import org.springframework.stereotype.Component;

@Component
public class MyAwesomeDependency {
    public String helloFor(String name, String lastName) {
        return "Hello " + name + "! " + lastName + " are you lost?";
    }
}
