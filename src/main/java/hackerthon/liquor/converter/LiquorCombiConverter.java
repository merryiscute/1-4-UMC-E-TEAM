package hackerthon.liquor.converter;

import hackerthon.liquor.domain.Category;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.service.CategoryService;
import hackerthon.liquor.web.dto.LiquorCombiRequestDTO;
import hackerthon.liquor.web.dto.LiquorCombiResponseDTO;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class LiquorCombiConverter {

    public static LiquorCombiPost toLiquorCombiPost (LiquorCombiRequestDTO.MakeDTO request){
        return LiquorCombiPost.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .picture(request.getPicture())
                .tag(request.getTag())
                .build();
    }


    public static LiquorCombiResponseDTO.JoinResultDTO createPostDTO(LiquorCombiPost liquorCombiPost) {
        return LiquorCombiResponseDTO.JoinResultDTO.builder()
                .postid(Optional.ofNullable(liquorCombiPost)
                        .map(LiquorCombiPost::getId)
                        .orElse(null))
                .createdAt(LocalDateTime.now())
                .build();
    }



}
