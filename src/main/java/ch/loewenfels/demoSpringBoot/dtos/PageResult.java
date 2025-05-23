package ch.loewenfels.demoSpringBoot.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageResult <T>{
    List<T> content;
    private Integer totalPages;
    private long totalElements;
    private Integer size;
    private Integer pageNumber;
}
