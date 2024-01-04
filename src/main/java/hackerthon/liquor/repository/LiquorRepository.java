package hackerthon.liquor.repository;

import hackerthon.liquor.domain.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiquorRepository extends JpaRepository<Liquor,Long> {

    List<Liquor> findByCategoryId(Long CategoryId);
}
