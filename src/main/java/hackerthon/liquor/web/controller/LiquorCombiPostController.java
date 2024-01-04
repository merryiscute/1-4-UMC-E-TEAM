package hackerthon.liquor.web.controller;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.converter.LiquorCombiPostConverter;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.service.LiquorCombiPostService;
import hackerthon.liquor.web.dto.LiquorCombiPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/liquorCombiPost")
public class LiquorCombiPostController {

    private final LiquorCombiPostService liquorCombiPostService;
    //전체 조회
    @GetMapping("")
    public ApiResponse<List<LiquorCombiPostResponseDTO.LiquirCombiDTO>> getList(){
        List<LiquorCombiPost> liquorCombiPostList = liquorCombiPostService.findAll();

        List<LiquorCombiPostResponseDTO.LiquirCombiDTO> liquorCombiPosts = LiquorCombiPostConverter.toLiquorCombiDTO(liquorCombiPostList);
        return ApiResponse.onSuccess(liquorCombiPosts);
    }

    @GetMapping("/{category_id}")
    public ApiResponse<List<LiquorCombiPostResponseDTO.LiquirCombiDTO>> getCategoryList(@PathVariable Long category_id){
        List<LiquorCombiPost> liquorCombiPostList = liquorCombiPostService.findByCategory(category_id);

        List<LiquorCombiPostResponseDTO.LiquirCombiDTO> liquorCombiPosts = LiquorCombiPostConverter.toLiquorCombiDTO(liquorCombiPostList);
        return ApiResponse.onSuccess(liquorCombiPosts);
    }
