package hackerthon.liquor.service;

import hackerthon.liquor.domain.Comment;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.repository.CommentRepository;
import hackerthon.liquor.repository.LiquorCombiPostRepository;
import hackerthon.liquor.repository.LiquorFoodPostRepository;
import hackerthon.liquor.repository.LiquorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LiquorServiceImpl implements LiquorService{

    private final LiquorRepository liquorRepository;
    private final LiquorCombiPostRepository liquorCombiPostRepository;
    private final LiquorFoodPostRepository liquorFoodPostRepository;
    private final CommentRepository commentRepository;

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

    @Override
    @Transactional
    public LiquorCombiPost findLCPost(Long postId) {
        LiquorCombiPost liquorCombiPost = liquorCombiPostRepository.findById(postId).get();

        return liquorCombiPost;
    }

    @Override
    public LiquorFoodPost findLFPost(Long postId) {
        LiquorFoodPost liquorFoodPost = liquorFoodPostRepository.findById(postId).get();

        return liquorFoodPost;
    }

    @Override
    public List<Comment> getLCComment(Long postId) {
        LiquorCombiPost liquorCombiPost = liquorCombiPostRepository.findById(postId).get();
        List<Comment> commentList = commentRepository.findAllByLiquorCombiPost(liquorCombiPost);

        return commentList;
    }

    @Override
    public List<Comment> getLFComment(Long postId) {
        LiquorFoodPost liquorFoodPost = liquorFoodPostRepository.findById(postId).get();
        List<Comment> commentList = commentRepository.findAllByLiquorFoodPost(liquorFoodPost);

        return commentList;
    }

    @Override
    public Optional<LiquorCombiPost> findById(Long postId) {
        return liquorCombiPostRepository.findById(postId);
    }

    @Override
    public List<Liquor> findAll() {
        return liquorRepository.findAll();
    }

    @Override
    public List<Liquor> getLiquorList() {
        List<Liquor> liquorList = liquorRepository.findAll();
        return liquorList;
    }

    @Override
    public List<Liquor> findByCategoryId(Long categoryId) {
        return liquorRepository.findByCategoryId(categoryId);
    }
}
