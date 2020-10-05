package com.example.accessingdatarest.repositories;

import java.util.List;

import com.example.accessingdatarest.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);

    List<Person> findByGender(@Param("gender") String gender);

}