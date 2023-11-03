package com.api.team.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDto {
    private String teamName;
    private int classment;
    private int matchPlayed;
    private int wins;
    private int matchDraw;
    private int defeat;
    private int points;
}
