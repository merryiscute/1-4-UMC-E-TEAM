package hackerthon.liquor.converter;

import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorFoodPost;
import hackerthon.liquor.web.dto.LiquorFoodPostResponseDTO;
import hackerthon.liquor.web.dto.LiquorResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LiquorFoodPostConverter {

    public static List<LiquorFoodPostResponseDTO.inquiryLiquorFoodDTO> toInquiryHLiquorFoodDTO(List<LiquorFoodPost> liquorFoodPosts) {

        return liquorFoodPosts.stream()
                .map(liquorFoodPost ->
                        LiquorFoodPostResponseDTO.inquiryLiquorFoodDTO.builder()
                                .liquorFood_Id(liquorFoodPost.getId())
                                .likes(liquorFoodPost.getLikes())
                                .tag(liquorFoodPost.getLiquor().getTag())
                                .title(liquorFoodPost.getTitle())
                                .picture(liquorFoodPost.getPicture())
                                .build()
                ).collect(Collectors.toList());

    }
}
