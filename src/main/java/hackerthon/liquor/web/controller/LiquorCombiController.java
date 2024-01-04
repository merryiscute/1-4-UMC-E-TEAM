package hackerthon.liquor.web.controller;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.converter.LiquorCombiConverter;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.service.LiquorCombiService;
import hackerthon.liquor.web.dto.LiquorCombiRequestDTO;
import hackerthon.liquor.web.dto.LiquorCombiResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/liquorCombi")
public class LiquorCombiController {
    private final LiquorCombiService liquorCombiService;

    @PostMapping
    public ApiResponse<LiquorCombiResponseDTO.JoinResultDTO> createPost(LiquorCombiRequestDTO.MakeDTO request){
        LiquorCombiPost liquorCombiPost = liquorCombiService.makePost(request);
        return ApiResponse.onSuccess(LiquorCombiConverter.createPostDTO(liquorCombiPost));
    }
}
