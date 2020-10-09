package com.example.accessingdatarest.services;

import com.example.accessingdatarest.domain.Integration;
import com.example.accessingdatarest.domain.Message;
import com.example.accessingdatarest.domain.Player;
import com.example.accessingdatarest.repositories.IntegrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegrationService {

    @Autowired
    IntegrationRepository integrationRepository;

    public Integration findById(Long id) {
        return integrationRepository.findById(id).orElse(null);
    }

    public List<Integration> findAll(int pageNumber, int rowPerPage) {
        List<Integration> integrations = new ArrayList<>();
        Pageable sortedByLastUpdateDesc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        integrationRepository.findAll(sortedByLastUpdateDesc).forEach(integrations::add);
        return integrations;
    }

    public Integration getByMessageAndSendingAppAndReceivingApp(Message message, Player sendingApp, Player receivingApp) {
        return integrationRepository.getByMessageAndSendingAppAndReceivingApp(message, sendingApp, receivingApp);
    };

    public Long count() {
        return integrationRepository.count();
    }
}
