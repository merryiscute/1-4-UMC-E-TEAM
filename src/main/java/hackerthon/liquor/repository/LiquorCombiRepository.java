package hackerthon.liquor.repository;

import hackerthon.liquor.domain.mapping.LiquorCombi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LiquorCombiRepository extends JpaRepository<LiquorCombi, Long> {
    Optional<LiquorCombi> findByLiquorId(Long id);
}
