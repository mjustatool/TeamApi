package com.api.team.web;


import com.api.team.dto.TeamDto;
import com.api.team.service.TeamService;
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

    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getTeams() throws IOException {
        return ResponseEntity.ok(teamService.getAllTeams());
    }


    public void instructions(){
        // jib mn graphql databse
        // ila kant database khawiya radi t3merha o dir createdAtt date ta3 db
        // ila kant database 3amra radi tchof createdAt wach fat 24sa3a 3la la date diyal dd
        // ila ahh radi temse7 kolchi o inserer data jdida
        // ila la radi treje3 dakchi li kayn fl database
    }
}
