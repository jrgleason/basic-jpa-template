package org.gleason;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Endpoint{
	@GetMapping("")
	@ResponseBody
	String get(){
		return "Hello World";
	}
}