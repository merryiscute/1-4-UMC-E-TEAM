package hackerthon.liquor.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LiquorFoodPostResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class inquiryLiquorFoodDTO implements Comparable<inquiryLiquorFoodDTO> {
        Long liquorFood_Id;
        String title;
        String tag;
        Integer likes;


        @Override
        public int compareTo(inquiryLiquorFoodDTO inquiryLiquorFoodDTO) {
            if (inquiryLiquorFoodDTO.likes < likes)
            {            return 1;
            }
            else if (inquiryLiquorFoodDTO.likes > likes)
            {            return -1;
            }
            return 0;
        }

        //사진처리필요
    }
}
