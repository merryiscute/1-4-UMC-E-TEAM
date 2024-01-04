package hackerthon.liquor.converter;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.web.dto.LiquorResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

public class LiquorConverter {

    public static LiquorResponseDTO.liquorCombiPostDTO toLiquorCombiPostDTO(LiquorCombiPost liquorCombiPost){
        return LiquorResponseDTO.liquorCombiPostDTO.builder()
                .id(liquorCombiPost.getId())
                .name(liquorCombiPost.getName())
                .likes(liquorCombiPost.getLikes())
                .picture(liquorCombiPost.getPicture())
                .build();
    }

    public static LiquorResponseDTO.liquorFoodPostDTO toLiquorFoodPostDTO(LiquorFoodPost liquorFoodPost){
        return LiquorResponseDTO.liquorFoodPostDTO.builder()
                .id(liquorFoodPost.getId())
                .name(liquorFoodPost.getName())
                .likes(liquorFoodPost.getLikes())
                .picture(liquorFoodPost.getPicture())
                .build();
    }

    public static LiquorResponseDTO.liquorDetailDTO toLiquorDetailDTO(Liquor liquor,
                                                                      List<LiquorCombiPost> liquorCombiPostList,
                                                                      List<LiquorFoodPost> liquorFoodPostList){

        List<LiquorResponseDTO.liquorCombiPostDTO> LCDTOList = liquorCombiPostList.stream()
                .map(LiquorConverter::toLiquorCombiPostDTO).collect(Collectors.toList());

        List<LiquorResponseDTO.liquorFoodPostDTO> LFDTOList = liquorFoodPostList.stream()
                .map(LiquorConverter::toLiquorFoodPostDTO).collect(Collectors.toList());

        return LiquorResponseDTO.liquorDetailDTO.builder()
                .name(liquor.getName())
                .percent(liquor.getPercent())
                .price(liquor.getPrice())
                .volume(liquor.getVolume())
                .description(liquor.getDescription())
                .tag(liquor.getTag())
                .picture(liquor.getPicture())
                .liquorCombiPostDTOList(LCDTOList)
                .liquorFoodPostDTOList(LFDTOList)
                .build();

    }
}
