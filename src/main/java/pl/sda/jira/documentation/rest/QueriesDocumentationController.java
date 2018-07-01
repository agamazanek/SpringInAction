package pl.sda.jira.documentation.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class QueriesDocumentationController {

    @RequestMapping(method = RequestMethod.POST)
    public String getCriteria(@RequestParam(value = "name") String name,
                      @RequestParam(value = "value") String value,
                      @RequestParam(value = "type") String type) {
        return "name " + name + ", value " + value + ",type " + type;

    }
}
