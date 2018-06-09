package pl.sda.jira.domain.service;

import pl.sda.jira.domain.UserRepository;
import pl.sda.jira.domain.dto.UserDto;
import pl.sda.jira.domain.exception.UserNotFoundException;
import pl.sda.jira.domain.model.User;

import java.util.UUID;

public class UserCrudService {
    private final UserRepository userRepository;

    public UserCrudService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findBy(String identifier) {
        if (userRepository.exists(identifier)) {
            return userRepository.findBy(identifier);
        }

        throw new UserNotFoundException(identifier);
    }

    public String add(UserDto userDto) {
        String identifier = UUID.randomUUID().toString();
        userRepository.add(new User(identifier, userDto.login));
        return identifier;
    }
}
