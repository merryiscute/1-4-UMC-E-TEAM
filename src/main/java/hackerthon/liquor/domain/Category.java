package hackerthon.liquor.domain;

import hackerthon.liquor.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name1;

    @Column(nullable = false, length = 20)
    private String name2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Liquor> liquorList = new ArrayList<>();

}
