package hackerthon.liquor.domain;

import hackerthon.liquor.apiPayload.code.BaseErrorCode;
import hackerthon.liquor.domain.common.BaseEntity;
import hackerthon.liquor.domain.mapping.LiquorCombi;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Liquor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "liquor", cascade = CascadeType.ALL)
    private List<LiquorCombi> liquorCombiList = new ArrayList<>();

    @OneToMany(mappedBy = "liquor", cascade = CascadeType.ALL)
    private List<LiquorFoodPost> liquorFoodPostList = new ArrayList<>();

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String percent;

    @Column(nullable = false, length = 40)
    private String price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 40)
    private String picture;

    @Column(nullable = false, length = 40)
    private String tag;

    @Column(nullable = false, length = 40)
    private String volume;

}
