package com.example.accessingdatarest.repositories;

import com.example.accessingdatarest.domain.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "message")
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
    Message findByCodeAndEvent(String code, String event);
}
