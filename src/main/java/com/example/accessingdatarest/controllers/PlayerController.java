package com.example.accessingdatarest.controllers;

import com.example.accessingdatarest.domain.Player;
import com.example.accessingdatarest.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 5;

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/players")
    public String getUsers(Model model,
                           @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Player> players = playerService.findAll(pageNumber, ROW_PER_PAGE);

        long count = playerService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("players", players);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "player-list";
    }

    @GetMapping(value = "/players/{userId}")
    public String getUserById(Model model, @PathVariable long userId) {
        Player player = null;
        try {
            player = playerService.findById(userId);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("player", player);
        return "player";
    }
}
