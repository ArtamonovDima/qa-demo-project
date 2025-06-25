package demo.qa.user.kafka;

import demo.qa.user.data.UserEntity;
import demo.qa.user.data.UserRepository;
import demo.qa.user.model.UserCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventsListener {

    private final UserRepository userRepository;

    public UserEventsListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "user.created", groupId = "user-service-group")
    public void handleUserCreated(UserCreatedEvent event) {
        System.out.println("Получено сообщение из Kafka: " + event);

        if (userRepository.findByEmail(event.email()).isEmpty()) {
            UserEntity newUser = new UserEntity();
            newUser.setName(event.name());
            newUser.setEmail(event.email());
            userRepository.save(newUser);
            System.out.println("Пользователь сохранён в базе: " + newUser);
        } else {
            System.out.println("Пользователь с таким email уже существует");
        }
    }
}
