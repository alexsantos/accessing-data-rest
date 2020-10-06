package com.example.accessingdatarest.repositories;

import com.example.accessingdatarest.domain.Mapper;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "mapper", collectionResourceRel = "api")
public interface MapperRepository extends PagingAndSortingRepository<Mapper, Long> {

}
