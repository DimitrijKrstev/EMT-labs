package com.example.emtlab1.repository;

import com.example.emtlab1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
