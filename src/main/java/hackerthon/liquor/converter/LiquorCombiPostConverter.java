package hackerthon.liquor.converter;

import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.web.dto.LiquorCombiPostResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LiquorCombiPostConverter {

    public static List<LiquorCombiPostResponseDTO.LiquirCombiDTO> toLiquorCombiDTO(List<LiquorCombiPost> liquorCombiPosts) {

        return liquorCombiPosts.stream()
                .map(liquorCombiPost ->
                        LiquorCombiPostResponseDTO.LiquirCombiDTO.builder()
                                .liquirCombi_id(liquorCombiPost.getId())
                                .title(liquorCombiPost.getTitle())
                                .content(liquorCombiPost.getContents())
                                .likes(liquorCombiPost.getLikes())
                                .build()
                ).collect(Collectors.toList());

    }



}
