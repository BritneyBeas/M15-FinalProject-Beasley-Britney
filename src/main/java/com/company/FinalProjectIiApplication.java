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
		Scanner scan = new Scanner(System.in);
		String input;
		do{
			System.out.println("+-------------------------+");
			System.out.println("|         Welcome to      |");
			System.out.println("|      Weather Station    |");
			System.out.println("+-------------------------+");
			System.out.println("Please make a selection:");
			System.out.println("1) To view the weather, please input a city.");
			System.out.println("2) Exit");

			input = scan.nextLine();
			System.out.println(input);

			if(input =="1") {
				WebClient client = WebClient.create("https://api.openweathermap.org/data/2.5/weather?q=Kittrell&appid=ec9d76111ba8c1310b8d585f4f335d13");
				Mono<String> response = client
						.get()
						.retrieve()
						.bodyToMono(String.class);

				String json = response.share().block();
				System.out.println(json);
			}
		}while(input!="2");





	}

}
