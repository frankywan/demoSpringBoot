package ch.loewenfels.demoSpringBoot.persistance;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long>,
        QuerydslPredicateExecutor<SchoolEntity>, QuerydslBinderCustomizer<QSchoolEntity> {

        @Override
        default void customize(QuerydslBindings bindings, QSchoolEntity root) {
                bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        }

        @Override
        Optional<SchoolEntity> findById(Long id);

        Page<SchoolEntity> findAll(Predicate search, Pageable pageable);
}
