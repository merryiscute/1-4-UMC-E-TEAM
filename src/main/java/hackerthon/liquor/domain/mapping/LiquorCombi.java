package hackerthon.liquor.domain.mapping;

import hackerthon.liquor.domain.Category;
import hackerthon.liquor.domain.Liquor;
import hackerthon.liquor.domain.LiquorCombiPost;
import hackerthon.liquor.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LiquorCombi extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liquor_id")
    private Liquor liquor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liquorCombiPost_id")
    private LiquorCombiPost liquorCombiPost;





}
