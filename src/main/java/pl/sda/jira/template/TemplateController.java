package pl.sda.jira.template;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @RequestMapping("/{number}")
    public ResponseEntity<String> luckThirteen(@PathVariable String number) {
        if ("13".equals(number)) {
            return new ResponseEntity<>("Lucky 13", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("This number: " + number + ", is not so lucky", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
