package hackerthon.liquor.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LiquorResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InquiryHomeLiquorDTO {
        Long Liquor_Id;
        String name;
        String percent;
        String price;
        String volume;
        String tag;

        //사진 어떻게 처리?
    }
}
