package com.api.team.repository;

import com.api.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRpository extends JpaRepository<Team,Integer> {
}
