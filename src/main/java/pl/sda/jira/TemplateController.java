package pl.sda.jira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {
    private final MyAwesomeDependency dependency;

    @Autowired
    public TemplateController(MyAwesomeDependency dependency) {
        this.dependency = dependency;
    }

    @RequestMapping(path = "/{identifier}", method = RequestMethod.DELETE)
    public String remove(@PathVariable String identifier) {
        return "Removed: " + identifier;
    }

    @RequestMapping(path = "/{identifier}", method = RequestMethod.GET)
    public String get(@PathVariable String identifier) {
        return "Retrieved: " + identifier;
    }

    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    public String helloWorld(String name, String lastName) {
        return dependency.helloFor(name, lastName);
    }

    @RequestMapping("/hello-world/{name}")
    public String helloWorldSomeone(@PathVariable String name) {
        return "Hello " + name + "! Good to see you again :)";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String create(@ModelAttribute TemplateDto templateDto) {
        return templateDto.getLastName()
                + " "
                + templateDto.getName()
                + ", mail: "
                + templateDto.getMail();
    }
}





