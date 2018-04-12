package org.gleason;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableAutoConfiguration
public class Application{
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}