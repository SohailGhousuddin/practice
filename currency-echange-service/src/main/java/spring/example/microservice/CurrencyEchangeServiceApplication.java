package spring.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyEchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyEchangeServiceApplication.class, args);
	}
}
