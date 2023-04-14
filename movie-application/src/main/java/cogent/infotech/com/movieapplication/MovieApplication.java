package cogent.infotech.com.movieapplication;

import cogent.infotech.com.entity.User;
import cogent.infotech.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MovieApplication {
	@Autowired
	UserRepository repository;

	@PostConstruct
	public void initUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(365, "jay", "Password", "jay@gmail.com"));

		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

}
