package pl.sda.jira.springBootExercise;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello-world")
    public String sayHelloWorld(){
        return "Hello World!";
    }

    @RequestMapping("/hello/{name}")
    public String sayHelloWorldToUser(@PathVariable String name){
        return "Hello " + name +"! Glad you're here!";
    }

    @RequestMapping("/hello")
    public String sayHelloWorld(@RequestParam(defaultValue = "NEW COMER", name = "name") String who){
        return "Hello " + who + "! Are you lost?";

    }

    @RequestMapping("/helloWorld")
    public String sayHelloWorld(@RequestParam(defaultValue = "NEW COMER", name = "name") String who, String newLocation){
        return "Hello " + who + "! Are you lost? You are being redirected to: " + newLocation;
    }

    @RequestMapping("/helloHello/{yourName}/{yourNewLocation}")
    public String sayNewHelloWorld(@PathVariable String yourName, @PathVariable String yourNewLocation){
        return "Hello " + yourName + ". You're being redirected to: " + yourNewLocation;
    }


}
