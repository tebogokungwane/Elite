package com.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.player.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
