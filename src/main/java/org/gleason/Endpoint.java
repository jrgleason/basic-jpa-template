package org.gleason;
import org.gleason.coffeeshop.domain.Person;
import org.gleason.coffeeshop.service.CoffeeShopService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Endpoint{
	@Autowired
	CoffeeShopService service;

	@GetMapping("")
	String get(){
		return "hello world";
	}

	@GetMapping("people")
	String people(){
		String result = "";
		for(Person person : service.getPeople())
		{
			result += person.getName();
		}
		return result;
	}
}