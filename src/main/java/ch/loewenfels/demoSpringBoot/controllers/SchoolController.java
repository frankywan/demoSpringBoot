package ch.loewenfels.demoSpringBoot.controllers;

import ch.loewenfels.demoSpringBoot.dtos.PageResult;
import ch.loewenfels.demoSpringBoot.dtos.SchoolClassDto;
import ch.loewenfels.demoSpringBoot.dtos.SchoolDto;
import ch.loewenfels.demoSpringBoot.persistance.SchoolEntity;
import ch.loewenfels.demoSpringBoot.services.SchoolService;
import com.querydsl.core.types.Predicate;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/school")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "01 School")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/")
    @PageableAsQueryParam
    public PageResult<SchoolDto> getAllSchools(@QuerydslPredicate(root = SchoolEntity.class) Predicate search,
                                               @Parameter(hidden = true) Pageable pageable) {
        return schoolService.getAllSchools(pageable, search);
    }

    @PostMapping("/")
    public SchoolDto addSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.addSchool(schoolDto);
    }

    @GetMapping("/{schoolId}")
    public SchoolDto getSchool(@PathVariable(value = "schoolId") Long schoolId) {
        return new SchoolDto();
    }

    @PatchMapping("/{schoolId}")
    public SchoolDto updateSchool(@PathVariable(value = "schoolId") Long schoolId, @RequestBody SchoolDto schoolDto) {
        return new SchoolDto();
    }

    @DeleteMapping("/{schoolId}")
    public void deleteSchool(@PathVariable(value = "schoolId") Long schoolId) {
        throw new NotImplementedException();
    }

    @GetMapping("/towns")
    public List<String> getTowns() {
        return schoolService.getDistinctTowns();
    }

    // School classes
    @GetMapping("/{schoolId}/schoolClass")
    @PageableAsQueryParam
    public PageResult<SchoolClassDto> getAllSchoolClasses(@QuerydslPredicate(root = SchoolEntity.class) Predicate search,
                                                          @Parameter(hidden = true) Pageable pageable,
                                                          @PathVariable(value = "schoolId") Long schoolId) {
        return PageResult.<SchoolClassDto>builder().build();
    }

    @PostMapping("/{schoolId}/schoolClass")
    public SchoolClassDto addSchoolClass(@PathVariable(value = "schoolId") Long schoolId,
                                         @RequestBody SchoolClassDto schoolClassDto) {
        return new SchoolClassDto();
    }
}
