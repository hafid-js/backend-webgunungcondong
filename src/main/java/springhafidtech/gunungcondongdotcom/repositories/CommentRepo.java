package springhafidtech.gunungcondongdotcom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springhafidtech.gunungcondongdotcom.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
