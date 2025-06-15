package demo.qa.user;

import demo.qa.user.data.UserEntity;
import demo.qa.user.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			if (userRepository.count() == 0) {
				userRepository.save(new UserEntity("Alice", "alice@example.com"));
				userRepository.save(new UserEntity("Bob", "bob@example.com"));
			}
		};
	}
}
