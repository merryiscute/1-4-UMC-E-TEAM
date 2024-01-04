package hackerthon.liquor.repository;

import hackerthon.liquor.domain.LiquorCombiPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiquorCombiPostRepository extends JpaRepository<LiquorCombiPost, Long> {

}
