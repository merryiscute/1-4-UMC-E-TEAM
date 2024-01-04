package hackerthon.liquor.repository;

import hackerthon.liquor.domain.LiquorCombiPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiquorCombiPostRepository extends JpaRepository<LiquorCombiPost, Long> {

}
