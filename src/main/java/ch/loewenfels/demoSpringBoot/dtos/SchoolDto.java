package ch.loewenfels.demoSpringBoot.dtos;

import ch.loewenfels.demoSpringBoot.types.SchoolType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String zip;
    private String town;
    private SchoolType type;
}
