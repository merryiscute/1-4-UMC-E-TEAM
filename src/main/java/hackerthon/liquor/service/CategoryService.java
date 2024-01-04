package hackerthon.liquor.service;

import hackerthon.liquor.domain.Category;
import hackerthon.liquor.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public Category findByName(String name){
        return categoryRepository.findByName2(name).get();
    }
}
