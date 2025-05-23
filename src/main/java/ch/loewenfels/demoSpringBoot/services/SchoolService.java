package ch.loewenfels.demoSpringBoot.services;

import ch.loewenfels.demoSpringBoot.dtos.PageResult;
import ch.loewenfels.demoSpringBoot.dtos.SchoolDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolService {
    public PageResult<SchoolDto> getAllSchools(Pageable pageable, Predicate search);
    SchoolDto addSchool(SchoolDto schoolDto);

    List<String> getDistinctTowns();
}
