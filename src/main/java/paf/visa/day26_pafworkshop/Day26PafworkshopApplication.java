package paf.visa.day26_pafworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import paf.visa.day26_pafworkshop.config.EnableCORS;

@SpringBootApplication
public class Day26PafworkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day26PafworkshopApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new EnableCORS("/api/*", "*");
	}

}
