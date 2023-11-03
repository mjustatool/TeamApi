package com.api.team.service;

import com.api.team.dto.TeamDto;
import com.api.team.entity.Team;
import com.api.team.mapper.TeamMapper;
import com.api.team.repository.TeamRpository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamHandleService {
    private final TeamRpository teamRpository;
    private final TeamService teamService;

    private final TeamMapper teamMapper;
    public TeamHandleService(TeamRpository teamRpository, TeamService teamService, TeamMapper teamMapper) {
        this.teamRpository = teamRpository;
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }


    public List<Team> getTeamsDB(String comp) throws IOException {

        List<Team> teams = teamRpository.findAll();
        if(!teams.isEmpty()){
            // hna 3amra
            Team team = teams.get(0);
            Instant ins = team.getCreatedAt().plus(1, ChronoUnit.DAYS); // hadi ka tched la date fach derty instert o ka tzied 3liha nhar

            if(ins.compareTo(Instant.now()) > 0){
                // hna makheskch ajouter
                return teams;
            }else{
               // hna khesk ajouter
                teamRpository.deleteAll();
                List<TeamDto> teamDtos = teamService.getAllTeams(comp);
                List<Team> newTeamsList = teamDtos.stream().map((teamMapper::mapToEntity)).toList();
                teamRpository.saveAll(newTeamsList);
                return newTeamsList;
            }
        }else {
            List<TeamDto> teamDtos = teamService.getAllTeams(comp);
            List<Team> newTeamsList = teamDtos.stream().map((teamMapper::mapToEntity)).toList();
            teamRpository.saveAll(newTeamsList);
            return newTeamsList;
        }
    }
}
