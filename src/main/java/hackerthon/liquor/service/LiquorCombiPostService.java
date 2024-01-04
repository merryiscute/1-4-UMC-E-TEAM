package hackerthon.liquor.service;

import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.repository.LiquorCombiPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LiquorCombiPostService {

    private final LiquorCombiPostRepository liquorCombiPostRepository;

    public List<LiquorCombiPost> findAll(){
        return liquorCombiPostRepository.findAll();
    }
    public List<LiquorCombiPost> findByCategory(Long id){
        List<LiquorCombiPost> list = liquorCombiPostRepository.findAllByCategoryId(id).stream()
                .collect(Collectors.toList());
        return list;

    }
}