package hackerthon.liquor.web.controller;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.converter.LiquorConverter;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.service.LiquorService.LiquorService;
import hackerthon.liquor.web.dto.LiquorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/liquor")
@RequiredArgsConstructor
public class LiquorController {

    private final LiquorService liquorService;

    /**
     * 메인페이지
     * home 띄우기
     */
    @GetMapping
    public ApiResponse<List<LiquorResponseDTO.InquiryHomeLiquorDTO>> home(){

        List<Liquor> liquors = liquorService.findAll();
        return ApiResponse.onSuccess(LiquorConverter.toInquiryHomeLiquorDTO(liquors));

    }


    /**
     * 메인페이지 - 카테고리 선택
     * categoryID를 이용해서 home 띄우기
     */
    @GetMapping("/{categoryId}")
    public ApiResponse<List<LiquorResponseDTO.InquiryHomeLiquorDTO>> home2(@PathVariable Long categoryId){
        List<Liquor> liquors = liquorService.findByCategoryId(categoryId);
        return ApiResponse.onSuccess(LiquorConverter.toInquiryHomeLiquorDTO(liquors));

    }
}
