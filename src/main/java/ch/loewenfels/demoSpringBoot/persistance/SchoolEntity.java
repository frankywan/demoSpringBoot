package ch.loewenfels.demoSpringBoot.persistance;

import ch.loewenfels.demoSpringBoot.types.SchoolType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(updatable = false, nullable = false)
    private Long id;

    private String zip;
    private String town;
    private SchoolType type;
}
