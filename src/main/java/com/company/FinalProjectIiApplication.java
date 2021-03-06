package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FinalProjectIiApplication<json> {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectIiApplication.class, args);
		WebClient client = WebClient.create("https://api.openweathermap.org/data/2.5/weather?q=Kittrell&appid=ec9d76111ba8c1310b8d585f4f335d13");
		Mono<String> response = client
				.get()
				.retrieve()
				.bodyToMono(String.class);

		String json = response.share().block();
		System.out.println(json);
	}

}
