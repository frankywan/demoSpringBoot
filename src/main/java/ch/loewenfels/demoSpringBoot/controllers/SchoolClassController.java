package ch.loewenfels.demoSpringBoot.controllers;

import ch.loewenfels.demoSpringBoot.dtos.PageResult;
import ch.loewenfels.demoSpringBoot.dtos.SchoolClassDto;
import ch.loewenfels.demoSpringBoot.dtos.SchoolDto;
import ch.loewenfels.demoSpringBoot.persistance.SchoolEntity;
import com.querydsl.core.types.Predicate;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/schoolClass")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "02 SchoolClass")
public class SchoolClassController {

    @GetMapping("/{schoolClassId}")
    public SchoolClassDto getSchoolClass(@PathVariable(value = "schoolClassId") Long schoolClassId) {
        return new SchoolClassDto();
    }

    @PatchMapping("/{schoolId}")
    public SchoolClassDto updateSchoolClass(@PathVariable(value = "schoolClassId") Long schoolClassId,
                                            @RequestBody SchoolDto schoolDto) {
        return new SchoolClassDto();
    }

    @DeleteMapping("/{schoolId}")
    public void deleteSchoolClass(@PathVariable(value = "schoolClassId") Long schoolId) {
        throw new NotImplementedException();
    }
}
