package hackerthon.liquor.repository;

import hackerthon.liquor.domain.LiquorFoodPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquorFoodPostRepository extends JpaRepository<LiquorFoodPost, Long> {
}
