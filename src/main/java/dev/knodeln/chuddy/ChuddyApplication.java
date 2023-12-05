package dev.knodeln.chuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.knodeln.chuddy.model.CalendarApp;

@SpringBootApplication
public class ChuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarApp.class, args);
	}

}
