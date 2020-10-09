package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.domain.Integration;
import com.example.accessingdatarest.repositories.MessageRepository;
import com.example.accessingdatarest.repositories.PlayerRepository;
import com.example.accessingdatarest.services.IntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IntegrationController {
    private static final Logger log = LoggerFactory.getLogger(IntegrationController.class);

    @Autowired
    IntegrationService integrationService;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    MessageRepository messageRepository;

    @GetMapping(value = "/integration/{intId}")
    public String getIntegrationById(Model model, @PathVariable long intId) {
        Integration integration = null;
        try {
            integration = integrationService.findById(intId);
            log.info("ID:" + integration.getId());
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("integration", integration);
        return "integration";
    }
}
