package hackerthon.liquor.repository;


import hackerthon.liquor.domain.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiquorRepository extends JpaRepository<Liquor, Long> {
}
