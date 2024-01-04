package hackerthon.liquor.repository;


import org.springframework.stereotype.Repository;
import hackerthon.liquor.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CategoryRepository {

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

}
