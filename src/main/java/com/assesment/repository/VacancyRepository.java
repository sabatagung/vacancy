package com.assesment.repository;

import com.assesment.entity.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {
    List<Vacancy> findByExpiryDateAfter(LocalDateTime now);
}
