package org.gleason;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Endpoint{
	@GetMapping("")
	String get(){
		return "hello world";
	}
}