package com.api.team.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="teams")
public class Team implements Comparable<Team>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String teamName;
    private int classment;
    private int matchPlayed;
    private int wins;
    private int matchDraw;
    private int defeat;
    private int points;
    private Instant createdAt;
    @Override
    public int compareTo(Team o) {
        return Integer.compare(this.getClassment(),o.getClassment());
    }
}
