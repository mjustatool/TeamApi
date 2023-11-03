package com.api.team.web;


import com.api.team.dto.TeamDto;
import com.api.team.entity.Team;
import com.api.team.service.TeamHandleService;
import com.api.team.service.TeamService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamResource {

    private final TeamService teamService;
    private final TeamHandleService teamHandleService;
    public TeamResource(TeamService teamService, TeamHandleService teamHandleService) {
        this.teamService = teamService;
        this.teamHandleService = teamHandleService;
    }

    @QueryMapping
    public List<Team> getDataInserted(@Argument String comp)  throws IOException {
        return teamHandleService.getTeamsDB(comp);
    }
}
