package hackerthon.liquor.service;

import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.web.dto.LiquorCombiRequestDTO;

public interface LiquorCombiService {
    LiquorCombiPost makePost(LiquorCombiRequestDTO.MakeDTO request);
}
