package com.assesment.controller;

import com.assesment.entity.Vacancy;
import com.assesment.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {
        return ResponseEntity.ok(vacancyService.createVacancy(vacancy));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Vacancy>> getActiveVacancies() {
        return ResponseEntity.ok(vacancyService.getActiveVacancies());
    }

    @GetMapping
    public ResponseEntity<List<Vacancy>> getAllVacancies() {
        return ResponseEntity.ok(vacancyService.getAllVacancies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacancy> updateVacancy(@PathVariable String id, @RequestBody Vacancy vacancy) {
        return ResponseEntity.ok(vacancyService.updateVacancy(id, vacancy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable String id) {
        vacancyService.deleteVacancy(id);
        return ResponseEntity.noContent().build();
    }
}
