package com.team200.moviecatalog.repository;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T> {
    String getKey();

    Specification<T> buildSpecification(String[] values);
}
