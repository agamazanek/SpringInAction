package pl.sda.jira.forum.domain;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForumController {

    @RequestMapping("/hello")
    public String helloForum(@RequestParam(defaultValue = "NO NAME", name = "name") String who) {
        return "Hello " + who + "! What You want ?";
    }

    @RequestMapping("/hello-forum/{name}")
    public String helloForumSomeone(@PathVariable String name) {
        return "Hello " + name + "! You are AWESOME!";
    }

    @RequestMapping("/hello2/{name},{surname}")
    public String helloForumWithFewParams(@PathVariable String name, @PathVariable String surname){
        return "Hello " + name + " " + surname + "! What You want ?";
    }
}
