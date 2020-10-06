package com.example.accessingdatarest.repositories;

import com.example.accessingdatarest.domain.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "player")
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {

}
