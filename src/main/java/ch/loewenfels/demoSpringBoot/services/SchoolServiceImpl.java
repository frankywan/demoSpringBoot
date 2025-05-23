package ch.loewenfels.demoSpringBoot.services;

import ch.loewenfels.demoSpringBoot.dtos.PageResult;
import ch.loewenfels.demoSpringBoot.dtos.SchoolDto;
import ch.loewenfels.demoSpringBoot.mappers.SchoolMapper;
import ch.loewenfels.demoSpringBoot.persistance.QSchoolEntity;
import ch.loewenfels.demoSpringBoot.persistance.SchoolEntity;
import ch.loewenfels.demoSpringBoot.persistance.SchoolRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public PageResult<SchoolDto> getAllSchools(Pageable pageable, Predicate search) {
        Page<SchoolEntity> page = schoolRepository.findAll(search, pageable);
        return PageResult.<SchoolDto>builder()
                .pageNumber(page.getNumber())
                .totalPages(page.getTotalPages())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .content(schoolMapper.mapListToSchoolDtos(page.getContent()))
                .build();
    }

    @Override
    public SchoolDto addSchool(SchoolDto schoolDto) {
        return schoolMapper.mapToSchoolDto(schoolRepository.save(schoolMapper.mapToSchoolEntity(schoolDto)));
    }

    @Override
    public List<String> getDistinctTowns() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QSchoolEntity qSchool = QSchoolEntity.schoolEntity;
        return queryFactory
                .select(qSchool.town)
                .from(qSchool)
                .groupBy(qSchool.town)
                .fetch();
    }
}
