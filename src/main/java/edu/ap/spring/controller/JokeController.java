package edu.ap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;
import edu.ap.spring.services.JokeService;

@Controller
@Scope("session")
public class JokeController {
	
	@Autowired
	private JokeService service;
	
	@Autowired
	private JokeRepository repository;
  
   @RequestMapping("/joke")
   public String joke() {
	   return "joke";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post( @RequestParam("firstName") String firstName,
		   				   @RequestParam("lastName") String lastName, Model model) {
	   
	   Joke newJoke = service.getJoke(firstName, lastName);
	   if(repository.findByJoke(newJoke.getJoke())== null) {
		   repository.save(newJoke);
	   }
	   
	   String jokeString = newJoke.getJoke();
	   model.addAttribute("joke", jokeString);
	   return "joke_post";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
