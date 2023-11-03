package com.api.team;

import com.api.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class TeamApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TeamApplication.class, args);

	}



}
