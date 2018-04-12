package org.gleason;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class Endpoint{
	@Autowired
	AddressRepository repo;
	@GetMapping("")
	@ResponseBody
	String get(){
		String val = "";
		for(AddressDomain domain: repo.findAll()){
			val += domain.getCity();
		}
		return val;
	}
}