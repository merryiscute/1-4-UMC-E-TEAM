package hackerthon.liquor.repository;

import hackerthon.liquor.domain.Comment;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.LiquorFoodPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findAllByLiquorCombiPost(LiquorCombiPost liquorCombiPost);
    public List<Comment> findAllByLiquorFoodPost(LiquorFoodPost liquorFoodPost);
}
