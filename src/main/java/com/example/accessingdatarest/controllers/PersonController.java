package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.domain.Enumerators.Gender;
import com.example.accessingdatarest.domain.Person;
import com.example.accessingdatarest.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("people")
    public List<Person> findByGender(@Param("gender") String gender) {
        for (Gender g: Gender.values()) {
            if (g.getValue().equals(gender)) {
                return personRepository.findByGender(g);
            }
        }
        return null;
    }
}
