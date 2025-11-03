package com.team200.moviecatalog.repository.country;

import com.team200.moviecatalog.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    boolean existsByNameIgnoreCase(String name);
}
