package com.api.team.mapper;

import com.api.team.dto.TeamDto;
import com.api.team.entity.Team;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class TeamMapper implements Mapper<Team, TeamDto>{

    private ModelMapper modelMapper;

    public TeamMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public Team mapToEntity(TeamDto teamDto) {
        Team team = modelMapper.map(teamDto, Team.class);
        team.setCreatedAt(Instant.now());

        return team;
    }

    @Override
    public TeamDto mapFromEntity(Team team) {
        TeamDto teamDto = modelMapper.map(team, TeamDto.class);

        return teamDto;
    }
}
