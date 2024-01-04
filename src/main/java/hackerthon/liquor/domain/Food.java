package hackerthon.liquor.domain;


import hackerthon.liquor.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String description;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<LiquorFoodPost> liquorFoodPostList = new ArrayList<>();

    @Column(nullable = false, length = 40)
    private String tag;
}
