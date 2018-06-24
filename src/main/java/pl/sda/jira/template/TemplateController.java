package pl.sda.jira.template;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @RequestMapping("/{number}")
    public String luckThirteen(@PathVariable String number) {
        if ("13".equals(number)) {
            return "Lucky 13";
        } else {
            throw new NotSoLuckyException(number);
        }
    }
}
