package hackerthon.liquor.web.controller;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.converter.LiquorConverter;
import hackerthon.liquor.domain.Comment;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.service.LiquorService;
import hackerthon.liquor.validation.anotation.ExistPost;
import hackerthon.liquor.web.dto.LiquorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/liquor")
public class LiquorController {

    private final LiquorService liquorService;

    @GetMapping("/{liquorId}")
    @Operation(summary = "상세 페이지 API")
    @Parameters({
            @Parameter(name = "liquorId", description = "술 아이디, path variable 입니다!")
    })
    public ApiResponse<LiquorResponseDTO.liquorDetailDTO> getLiquorDetail(@PathVariable(name = "liquorId") Long liquorId){
        Liquor liquor = liquorService.findLiquor(liquorId);
        return ApiResponse.onSuccess(LiquorConverter.toLiquorDetailDTO(liquor, liquorService.getLiquorCombiPostList(), liquorService.getLiquorFoodPostList()));
    }

    @GetMapping("/liquorCombiPost/{postId}")
    @Operation(summary = "술 꿀조합 게시글 조회 API")
    @Parameters({
            @Parameter(name = "postId", description = "술 꿀조합 게시글 아이디, path variable 입니다!")
    })
    public ApiResponse<LiquorResponseDTO.liquorCombiPostDTO> getLiquorCombiPost(@ExistPost @PathVariable(name = "postId") Long postId){
        LiquorCombiPost liquorCombiPost = liquorService.findLCPost(postId);
        List<Comment> commentList = liquorService.getLCComment(postId);

        return ApiResponse.onSuccess(LiquorConverter.toLiquorCombiPostDTO(liquorCombiPost, commentList));
    }

    @GetMapping("/liquorFoodPost/{postId}")
    @Operation(summary = "안주 꿀조합 게시글 조회 API")
    @Parameters({
            @Parameter(name = "postId", description = "안주 꿀조합 게시글 아이디, path variable 입니다!")
    })
    public ApiResponse<LiquorResponseDTO.liquorFoodPostDTO> getLiquorFoodPost(@PathVariable(name = "postId") Long postId){
        LiquorFoodPost liquorFoodPost = liquorService.findLFPost(postId);
        List<Comment> commentList = liquorService.getLFComment(postId);

        return ApiResponse.onSuccess(LiquorConverter.toLiquorFoodPostDTO(liquorFoodPost, commentList));
    }
}
