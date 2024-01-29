package springhafidtech.gunungcondongdotcom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springhafidtech.gunungcondongdotcom.entities.Category;
import springhafidtech.gunungcondongdotcom.entities.Post;
import springhafidtech.gunungcondongdotcom.entities.User;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory (Category category);

    List<Post> findByTitleContaining (String title);
}
