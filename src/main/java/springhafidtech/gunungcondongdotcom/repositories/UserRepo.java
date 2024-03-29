package springhafidtech.gunungcondongdotcom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springhafidtech.gunungcondongdotcom.entities.User;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
