package hackerthon.liquor.service;

import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.repository.LiquorFoodPostRepository;
import hackerthon.liquor.repository.LiquorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LiquorFoodPostServiceImpl implements LiquorFoodPostService{

    private final LiquorFoodPostRepository liquorFoodPostRepository;

    private final LiquorRepository liquorRepository;

    @Override
    public List<LiquorFoodPost> findAll() {
        List<LiquorFoodPost> liquorFoodPosts = liquorFoodPostRepository.findAll();
        return liquorFoodPosts;
    }

    @Override
    public List<LiquorFoodPost> findByCategoryId(Long categoryId) {

        List<Liquor> liquors = liquorRepository.findByCategoryId(categoryId);

        List<LiquorFoodPost> liquorFoodPosts = liquors.stream()
                .map(liquor -> liquorFoodPostRepository.findByLiquorId(liquor.getId())
                ).collect(Collectors.toList()).stream().flatMap(e -> e.stream()).collect(Collectors.toList());


        return liquorFoodPosts;
    }
}
