package com.assesment.service;

import com.assesment.entity.Vacancy;
import com.assesment.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    public Vacancy createVacancy(Vacancy vacancy) {
        vacancy.setPublishDate(LocalDateTime.now());
        vacancy.setExpiryDate(LocalDateTime.now().plusDays(30)); // Set expiry date
        return vacancyRepository.save(vacancy);
    }

    public List<Vacancy> getActiveVacancies() {
        return vacancyRepository.findByExpiryDateAfter(LocalDateTime.now());
    }

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public Vacancy updateVacancy(String id, Vacancy vacancy) {
        vacancy.setId(id);
        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(String id) {
        vacancyRepository.deleteById(id);
    }
}
