package hackerthon.liquor.web.controller;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.converter.LiquorConverter;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.service.LiquorService;
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
}
