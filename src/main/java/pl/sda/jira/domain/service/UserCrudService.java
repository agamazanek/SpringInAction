package pl.sda.jira.domain.service;

import pl.sda.jira.domain.UserRepository;
import pl.sda.jira.domain.dto.UserDto;
import pl.sda.jira.domain.exception.UserNotFoundException;
import pl.sda.jira.domain.model.User;

public class UserCrudService {
    private final UserRepository userRepository;
    private final UserIdentifier userIdentifier;

    UserCrudService(UserRepository userRepository, UserIdentifier userIdentifier) {
        this.userRepository = userRepository;
        this.userIdentifier = userIdentifier;
    }

    public User findBy(String identifier) {
        if (userRepository.exists(identifier)) {
            return userRepository.findBy(identifier);
        }

        throw new UserNotFoundException(identifier);
    }

    public String add(UserDto userDto) {
        String identifier = userIdentifier.create();
        userRepository.add(new User(identifier, userDto.login));
        return identifier;
    }

    public void remove(String identifier) {
        userRepository.remove(identifier);
    }

    public void update(String identifier, UserDto userDto) {
        User user = userRepository.findBy(identifier);
        user.changeLogin(userDto.login);
        userRepository.replace(user);

    }
}
