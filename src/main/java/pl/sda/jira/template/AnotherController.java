package pl.sda.jira.template;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/another")
public class AnotherController {

    @RequestMapping()
    public void doSomething() {
        throw new NotSoLuckyException("123");
    }
}
