package com.api.team.service;

import com.api.team.dto.Dto;
import com.api.team.entity.Team;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class TeamService implements Dto<Team> {
    private final String urlTeams = "http://localhost:9090/apiMatch?league=";
    @Override
    public List<Team> getTeams() {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        return null;
    }

}
