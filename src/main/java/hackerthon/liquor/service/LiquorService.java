package hackerthon.liquor.service;

import hackerthon.liquor.domain.Comment;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.domain.mapping.LiquorCombi;

import java.util.List;

public interface LiquorService {
    public Liquor findLiquor(Long liquorId);
    public List<LiquorCombiPost> getLiquorCombiPostList();
    public List<LiquorFoodPost> getLiquorFoodPostList();
    public LiquorCombiPost findLCPost(Long postId);
    public LiquorFoodPost findLFPost(Long postId);
    public List<Comment> getCommentList(Long postId);
}
