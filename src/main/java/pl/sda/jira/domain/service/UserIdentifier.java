package pl.sda.jira.domain.service;

import java.util.UUID;

class UserIdentifier {
    public String create() {
        return UUID.randomUUID().toString();
    }
}
