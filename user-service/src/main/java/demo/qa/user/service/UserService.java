package demo.qa.user.service;

import demo.qa.user.data.UserEntity;
import demo.qa.user.data.UserRepository;
import demo.qa.user.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto dto) {
        UserEntity entity = new UserEntity(dto.getName(), dto.getEmail());
        UserEntity saved = userRepository.save(entity);
        return new UserDto(saved.getName(), saved.getEmail());
    }
}
