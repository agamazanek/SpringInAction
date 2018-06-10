package pl.sda.jira.domain.service;

import java.util.UUID;

public class ForumIdentifier {
    public String create() {
        return UUID.randomUUID().toString();
    }
}
