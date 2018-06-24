package pl.sda.jira.forum.domain;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forum")
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello-forum/{name}")
    public String helloForum(@PathVariable String name) {
        return "Name of this forum is: " + name;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String create(@ModelAttribute ForumDto forumDto) {
        return forumService.add(forumDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public String update(@ModelAttribute ForumDto forumDto, @PathVariable String id) {
        forumService.update(id, forumDto);
        return "Forum name has been changed: " + forumDto.getName();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{forumId}")
    public String delete(@ModelAttribute ForumDto forumDto, @PathVariable String forumId) {
        forumService.remove(forumId);
        return "Forum with id: " + forumId + " deleted";
    }
}