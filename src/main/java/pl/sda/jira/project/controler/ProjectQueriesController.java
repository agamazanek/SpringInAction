package pl.sda.jira.project.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectQueriesController {

    @RequestMapping( method = RequestMethod.POST)
    public String read(@RequestParam String column_name, @RequestParam String value, @RequestParam String type){
        return "I received: "+column_name+", "+value+", "+type;
    }
}
