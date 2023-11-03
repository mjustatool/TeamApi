package com.api.team.dto;

import com.api.team.entity.Team;

import java.util.List;
import java.util.Optional;

public interface Dto <T>{
    public List<Team> getTeams();
}
