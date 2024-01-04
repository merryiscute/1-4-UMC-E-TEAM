package hackerthon.liquor.domain;

import hackerthon.liquor.domain.common.BaseEntity;
import hackerthon.liquor.domain.mapping.LiquorCombi;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liquorCombi_id")
    private LiquorCombiPost liquorCombiPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liquorFood_id")
    private LiquorFoodPost liquorFoodPost;

    @Column(nullable = false)
    private String contents;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer writer;







}
