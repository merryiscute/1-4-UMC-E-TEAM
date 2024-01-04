package hackerthon.liquor.repository;

import hackerthon.liquor.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findAllById(Long postId);
}
