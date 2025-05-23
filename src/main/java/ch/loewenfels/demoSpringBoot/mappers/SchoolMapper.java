package ch.loewenfels.demoSpringBoot.mappers;

import ch.loewenfels.demoSpringBoot.dtos.SchoolDto;
import ch.loewenfels.demoSpringBoot.persistance.SchoolEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper()
public interface SchoolMapper {
    @Named("toSchoolDtoMapping")
    SchoolDto mapToSchoolDto(SchoolEntity schoolEntity);

    @IterableMapping(qualifiedByName = "toSchoolDtoMapping")
    List<SchoolDto> mapListToSchoolDtos(List<SchoolEntity> contestEntities);

    SchoolEntity mapToSchoolEntity(SchoolDto schoolDto);
}
