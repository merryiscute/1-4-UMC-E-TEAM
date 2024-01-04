package hackerthon.liquor.service.LiquorService;

import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.repository.LiquorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LiquorServiceImpl implements LiquorService {

    private final LiquorRepository liquorRepository;

    @Override
    public List<Liquor> findAll() {
        List<Liquor> liquors = liquorRepository.findAll();
        return liquors;


    }

    @Override
    public List<Liquor> findByCategoryId(Long categoryId) {
        return liquorRepository.findByCategoryId(categoryId);
    }
}
