package hackerthon.liquor.repository;


import hackerthon.liquor.domain.LiquorCombiPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LiquorCombiPostRepository extends JpaRepository<LiquorCombiPost, Long> {
    Optional<LiquorCombiPost> findAllByCategoryId(Long id);
}
