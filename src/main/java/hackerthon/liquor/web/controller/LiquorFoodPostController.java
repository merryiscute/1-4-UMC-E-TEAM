package hackerthon.liquor.web.controller;


import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.converter.LiquorFoodPostConverter;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.service.LiquorFoodPostService;
import hackerthon.liquor.web.dto.LiquorFoodPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/liquorFoodPost")
@RequiredArgsConstructor
public class LiquorFoodPostController {

    private final LiquorFoodPostService liquorFoodPostService;


    /**
     * 안주조합레시피 조회
     * 
     */
    @GetMapping("")
    public ApiResponse<List<LiquorFoodPostResponseDTO.inquiryLiquorFoodDTO>> inquiryLiquorFoodRecipe(){
        List<LiquorFoodPost> liquorFoodPosts = liquorFoodPostService.findAll();

        List<LiquorFoodPostResponseDTO.inquiryLiquorFoodDTO> inquiryLiquorFoodDTOS = LiquorFoodPostConverter.toInquiryHLiquorFoodDTO(liquorFoodPosts);
        Collections.sort(inquiryLiquorFoodDTOS,Collections.reverseOrder()); //좋아요로 내림차순으로 정렬
        return ApiResponse.onSuccess(inquiryLiquorFoodDTOS);
    }

    /**
     * 안주조합레시피 카테고리ID를 이용해서 조회
     *
     */
    @GetMapping("/{categoryId}")
    public ApiResponse<List<LiquorFoodPostResponseDTO.inquiryLiquorFoodDTO>> inquiryLiquorFoodRecipe2(@PathVariable Long categoryId){
        List<LiquorFoodPost> liquorFoodPosts = liquorFoodPostService.findByCategoryId(categoryId);

        List<LiquorFoodPostResponseDTO.inquiryLiquorFoodDTO> inquiryLiquorFoodDTOS = LiquorFoodPostConverter.toInquiryHLiquorFoodDTO(liquorFoodPosts);
        Collections.sort(inquiryLiquorFoodDTOS,Collections.reverseOrder()); //좋아요로 내림차순으로 정렬
        return ApiResponse.onSuccess(inquiryLiquorFoodDTOS);
    }
}
