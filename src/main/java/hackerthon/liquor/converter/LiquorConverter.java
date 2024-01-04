package hackerthon.liquor.converter;

import hackerthon.liquor.apiPayload.ApiResponse;
import hackerthon.liquor.domain.Comment;
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
                .title(liquorCombiPost.getTitle())
                .likes(liquorCombiPost.getLikes())
                .picture(liquorCombiPost.getPicture())
                .build();
    }

    public static LiquorResponseDTO.liquorFoodPostDTO toLiquorFoodPostDTO(LiquorFoodPost liquorFoodPost){
        return LiquorResponseDTO.liquorFoodPostDTO.builder()
                .id(liquorFoodPost.getId())
                .title(liquorFoodPost.getTitle())
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

    public static List<LiquorResponseDTO.liquorDetailDTO> toInquiryHomeLiquorDTO(List<Liquor> liquors) {

        return liquors.stream()
                .map(liquor ->
                        LiquorResponseDTO.liquorDetailDTO.builder()
                                .Liquor_Id(liquor.getId())
                                .name(liquor.getName())
                                .percent(liquor.getPercent())
                                .price(liquor.getPrice())
                                .tag(liquor.getTag())
                                .volume(liquor.getVolume())
                                .build()
                ).collect(Collectors.toList());

    }
    public static LiquorResponseDTO.commentDTO toCommentDTO(Comment comment){
        return LiquorResponseDTO.commentDTO.builder()
                .writer(comment.getWriter())
                .contents(comment.getContents())
                .build();
    }

    public static LiquorResponseDTO.liquorCombiPostDTO toLiquorCombiPostDTO(LiquorCombiPost liquorCombiPost,
                                                                                List<Comment> commentList){
        List<LiquorResponseDTO.commentDTO> commentDTOList = commentList.stream()
                .map(LiquorConverter::toCommentDTO).collect(Collectors.toList());

        return LiquorResponseDTO.liquorCombiPostDTO.builder()
                .id(liquorCombiPost.getId())
                .title(liquorCombiPost.getTitle())
                .tag(liquorCombiPost.getTag())
                .contents(liquorCombiPost.getContents())
                .likes(liquorCombiPost.getLikes())
                .commentList(commentDTOList)
                .build();
    }

    public static LiquorResponseDTO.liquorFoodPostDTO toLiquorFoodPostDTO(LiquorFoodPost liquorFoodPost,
                                                                                List<Comment> commentList) {
        List<LiquorResponseDTO.commentDTO> commentDTOList = commentList.stream()
                .map(LiquorConverter::toCommentDTO).collect(Collectors.toList());

        return LiquorResponseDTO.liquorFoodPostDTO.builder()
                .id(liquorFoodPost.getId())
                .title(liquorFoodPost.getTitle())
                .tag(liquorFoodPost.getTag())
                .contents(liquorFoodPost.getContents())
                .likes(liquorFoodPost.getLikes())
                .commentList(commentDTOList)
                .build();
    }

    public static List<LiquorResponseDTO.liquorDetailDTO> toliquorDetailDTO(List<Liquor> liquors) {

        return liquors.stream()
                .map(liquor ->
                        LiquorResponseDTO.liquorDetailDTO.builder()
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
