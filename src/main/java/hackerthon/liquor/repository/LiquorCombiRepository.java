package hackerthon.liquor.repository;

import hackerthon.liquor.domain.mapping.LiquorCombi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquorCombiRepository extends JpaRepository<LiquorCombi, Long> {

}
