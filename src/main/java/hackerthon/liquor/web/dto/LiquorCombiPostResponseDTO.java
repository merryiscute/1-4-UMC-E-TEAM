package hackerthon.liquor.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LiquorCombiPostResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LiquirCombiDTO {
        Long liquirCombi_id;
        String title;
        String content;
        String tag;
        Integer likes;
        String picture;
    }

}
