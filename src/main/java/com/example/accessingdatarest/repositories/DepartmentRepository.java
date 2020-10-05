package com.example.accessingdatarest.repositories;

import com.example.accessingdatarest.domain.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "department")
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

}
