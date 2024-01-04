package hackerthon.liquor.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class LiquorResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class liquorDetailDTO{
        String name;
        String percent;
        String price;
        String volume;
        String description;
        String tag;
        String picture;

        List<liquorCombiPostDTO> liquorCombiPostDTOList;
        List<liquorFoodPostDTO> liquorFoodPostDTOList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class liquorCombiPostDTO{
        Long id;
        String name;
        String contents;
        Integer likes;
        String picture;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class liquorFoodPostDTO{
        Long id;
        String name;
        String contents;
        Integer likes;
        String picture;
    }
}
