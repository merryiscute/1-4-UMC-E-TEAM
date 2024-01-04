package hackerthon.liquor.service;

import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.repository.LiquorCombiPostRepository;
import hackerthon.liquor.repository.LiquorFoodPostRepository;
import hackerthon.liquor.repository.LiquorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LiquorServiceImpl implements LiquorService{
    private LiquorRepository liquorRepository;
    private LiquorCombiPostRepository liquorCombiPostRepository;
    private LiquorFoodPostRepository liquorFoodPostRepository;

    @Override
    public Liquor findLiquor(Long liquorId) {
        Liquor liquor = liquorRepository.findById(liquorId).get();

        return liquor;
    }

    @Override
    public List<LiquorCombiPost> getLiquorCombiPostList() {
        List<LiquorCombiPost> LCPostList = liquorCombiPostRepository.findAll();

        return LCPostList;
    }

    @Override
    public List<LiquorFoodPost> getLiquorFoodPostList() {
        List<LiquorFoodPost> LFPostList = liquorFoodPostRepository.findAll();

        return LFPostList;
    }
}
