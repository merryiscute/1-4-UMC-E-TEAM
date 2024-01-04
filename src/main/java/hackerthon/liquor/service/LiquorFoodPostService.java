package hackerthon.liquor.service;

import hackerthon.liquor.domain.LiquorFoodPost;

import java.util.List;

public interface LiquorFoodPostService {
    public List<LiquorFoodPost> findAll();

    List<LiquorFoodPost> findByCategoryId(Long categoryId);
}
