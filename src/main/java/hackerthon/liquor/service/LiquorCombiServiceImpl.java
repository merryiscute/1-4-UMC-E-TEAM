package hackerthon.liquor.service;

import hackerthon.liquor.converter.LiquorCombiConverter;
import hackerthon.liquor.domain.Category;
import hackerthon.liquor.domain.LiquorCombiPost;

import hackerthon.liquor.repository.CategoryRepository;
import hackerthon.liquor.repository.LiquorCombiPostRepository;
import hackerthon.liquor.web.dto.LiquorCombiRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class LiquorCombiServiceImpl implements LiquorCombiService{
    private final LiquorCombiPostRepository liquorCombiPostRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public LiquorCombiPost makePost(LiquorCombiRequestDTO.MakeDTO request) {
        LiquorCombiPost newPost = LiquorCombiConverter.toLiquorCombiPost(request);
        Category category = categoryRepository.findByName2(request.getName2()).get();
        newPost.setCategory(category);

        liquorCombiPostRepository.save(newPost);
        return newPost;
    }
}
