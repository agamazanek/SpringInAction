package pl.sda.jira;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    public String helloWorld(@RequestParam(defaultValue = "NO NAME", name = "name") String who) {
        return "Hello " + who + "! Are you lost?";
    }

    @RequestMapping("/hello-world/{name}")
    public String helloWorldSomeone(@PathVariable String name) {
        return "Hello " + name + "! Good to see you again :)";
    }

    @RequestMapping("/hallo2")
    public String helloWithTwoparams(@RequestParam(defaultValue = "name", name = "name") String name,
                                     @RequestParam(defaultValue = "surname", name = "surname") String surname,
                                     @RequestParam(defaultValue = "nick", name = "nick") String nick) {
        return "Hello " + name + " " + surname + " known as " + nick;
    }
}
