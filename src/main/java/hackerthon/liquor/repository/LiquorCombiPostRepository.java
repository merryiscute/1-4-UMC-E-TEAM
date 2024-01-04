package hackerthon.liquor.repository;

import hackerthon.liquor.domain.LiquorCombiPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiquorCombiPostRepository extends JpaRepository<LiquorCombiPost, Long> {
}
