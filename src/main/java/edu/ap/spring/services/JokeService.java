package edu.ap.spring.services;

import javax.json.JsonObject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.ap.spring.jpa.Joke;

@Service
public class JokeService {
	private String baseURL = "http://api.icndb.com/jokes/random";
	
	
	public Joke getJoke(String firstName, String lastName) {
		RestTemplate restTemplate = new RestTemplate();
		Joke newJoke;
		String urlString = baseURL + "?firstName="+firstName+"&lastName="+lastName;
		
		String jokeObjectString = restTemplate.getForObject(urlString, String.class);
		String[] stringArray = jokeObjectString.split("\"");
		String jokeString = stringArray[11];
		System.out.println(jokeString);
		newJoke = new Joke(jokeString);
		return newJoke;
	}
}
