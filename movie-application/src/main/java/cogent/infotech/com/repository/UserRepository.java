package cogent.infotech.com.repository;

import cogent.infotech.com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String name);
}

