package org.gleason;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySources({
//		@PropertySource("classpath:datasource.properties"),
		@PropertySource("classpath:auth0.properties"),
		@PropertySource("classpath:amazon.properties")
})
public class Application{
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}