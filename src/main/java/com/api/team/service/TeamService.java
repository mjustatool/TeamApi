package com.api.team.service;

import com.api.team.dto.Dto;
import com.api.team.dto.TeamDto;
import com.api.team.entity.Team;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Service
@Slf4j
public class TeamService  {
    private final String baseUrl = "http://localhost:9090";
    private final String urlTemms = "/apiMatch?league=premier_league";

    @Autowired
    private OkHttpClient client;
    public List<TeamDto> getAllTeams() throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl+urlTemms)
                .build();
        List<TeamDto> teamDtos = new ArrayList<>();
        Response response = client.newCall(request).execute();
        JSONArray jsonArray = new JSONArray(response.body().string());
        for (int i = 0 ; i < jsonArray.length() ; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            TeamDto teamDto = TeamDto.builder()
                    .teamName(jsonObject.getString("teamName"))
                    .classment(jsonObject.getInt("classment"))
                    .wins(jsonObject.getInt("wins"))
                    .points(jsonObject.getInt("points"))
                    .defeat(jsonObject.getInt("defeat"))
                    .matchPlayed(jsonObject.getInt("matchPlayed"))
                    .matchDraw(jsonObject.getInt("matchDraw"))
                    .build();
            teamDtos.add(teamDto);

        }
        return teamDtos;
    }








}
