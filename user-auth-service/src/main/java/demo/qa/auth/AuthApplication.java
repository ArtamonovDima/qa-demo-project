package demo.qa.auth;

import demo.qa.auth.data.AuthUser;
import demo.qa.auth.data.AuthUserRepository;
import demo.qa.auth.model.UserCreatedEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	CommandLineRunner initAuthUsers(AuthUserRepository repository, PasswordEncoder encoder,
									KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
		return args -> {
			if (repository.findByUsername("admin").isEmpty()) {
				repository.save(new AuthUser(
						"admin",
						encoder.encode("admin123"),
						"ADMIN"
				));
			}
//			UserCreatedEvent event = new UserCreatedEvent(
//					"Admin",                // name — то, что будет отображаться в списке
//					"admin@example.com"     // email — то, что тоже есть в UserEntity
//			);
//			kafkaTemplate.send("user.created", event);
		};
	}
}
