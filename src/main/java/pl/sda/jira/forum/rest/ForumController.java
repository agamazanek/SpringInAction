package pl.sda.jira.forum.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.jira.forum.dto.ForumDto;
import pl.sda.jira.forum.domain.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {
    private final ForumService forumService;
@Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ForumDto read(@PathVariable long id) {
        return forumService.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public long create(@ModelAttribute ForumDto forumDto) {
        return forumService.add(forumDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public String update(@ModelAttribute ForumDto forumDto, @PathVariable long id) {
        forumService.update(id, forumDto);
        return "Forum name has been changed: " + forumDto.getName();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{forumId}")
    public void delete(@ModelAttribute ForumDto forumDto, @PathVariable long forumId) {
        forumService.remove(forumId);
    }
}