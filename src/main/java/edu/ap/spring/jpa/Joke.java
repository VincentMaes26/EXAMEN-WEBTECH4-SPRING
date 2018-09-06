package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Joke {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String joke;
	
	public Joke() {}
	
	public Joke(String joke) {
		this.setJoke(joke);
	}

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}
	
	
}
