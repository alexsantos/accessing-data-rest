package com.example.accessingdatarest.repositories;

import com.example.accessingdatarest.domain.Integration;
import com.example.accessingdatarest.domain.Message;
import com.example.accessingdatarest.domain.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "integration")
public interface IntegrationRepository extends PagingAndSortingRepository<Integration, Long> {
    Integration getByMessageAndSendingAppAndReceivingApp(Message message, Player sendingApp, Player receivingApp);
}
