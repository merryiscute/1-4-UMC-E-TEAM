package hackerthon.liquor.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

public class LiquorCombiRequestDTO {
    @Getter @Setter
    public static class MakeDTO{
        @NotNull
        String title;

        @NotNull
        String contents;

        @NotNull
        String picture;

        @NotNull
        String tag;

        @NotNull
        String name1;

        @NotNull
        String name2;



    }
}
