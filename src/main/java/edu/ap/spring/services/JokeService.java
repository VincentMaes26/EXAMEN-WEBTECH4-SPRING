package edu.ap.spring.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.ap.spring.jpa.Joke;

@Service
public class JokeService {
	private String baseURL = "http://api.icndb.com/jokes/random";
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public Joke getJoke(String firstName, String lastName) {
		RestTemplate restTemplate = new RestTemplate();
		Joke newJoke = new Joke();
		String url = baseURL + "?firstName="+firstName+"&lastName="+lastName;
		newJoke = restTemplate.getForObject(url, Joke.class);
		return newJoke;
	}
}
