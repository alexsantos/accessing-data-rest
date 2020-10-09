package com.example.accessingdatarest.services;

import com.example.accessingdatarest.domain.Player;
import com.example.accessingdatarest.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> findAll(int pageNumber, int rowPerPage) {
        List<Player> users = new ArrayList<>();
        Pageable sortedByLastUpdateDesc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());
        playerRepository.findAll(sortedByLastUpdateDesc).forEach(users::add);
        return users;
    }

    public Long count() {
        return playerRepository.count();
    }
}
