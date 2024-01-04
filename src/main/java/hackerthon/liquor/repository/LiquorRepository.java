package hackerthon.liquor.repository;

import hackerthon.liquor.domain.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LiquorRepository extends JpaRepository<Liquor, Long> {
    List<Liquor> findByCategoryId(Long CategoryId);
    Optional<Liquor> findByCategoryId(Long id);

}
