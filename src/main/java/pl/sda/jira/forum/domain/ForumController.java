package pl.sda.jira.forum.domain;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forum")
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService){
        this.forumService = forumService;
    }

    @RequestMapping("/hello-forum/{name}")
    public String helloForum(@PathVariable String name){
       return "Name of this forum is: " + name;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String create(@ModelAttribute ForumDto forumDto){
        return forumService.add(forumDto);
    }
}
