package hackerthon.liquor.converter;

import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.web.dto.LiquorResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LiquorConverter {

    public static List<LiquorResponseDTO.InquiryHomeLiquorDTO> toInquiryHomeLiquorDTO(List<Liquor> liquors) {

        return liquors.stream()
                .map(liquor ->
                        LiquorResponseDTO.InquiryHomeLiquorDTO.builder()
                                .Liquor_Id(liquor.getId())
                                .name(liquor.getName())
                                .percent(liquor.getPercent())
                                .price(liquor.getPrice())
                                .tag(liquor.getTag())
                                .volume(liquor.getVolume())
                                .build()
                ).collect(Collectors.toList());

    }
}
