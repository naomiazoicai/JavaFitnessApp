package map.project.FitnessCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessCenterApplication.class, args);
		// Make sure Budget with id 1 exists in database
		//TODO Decorator for when a subscription is added, to increase the price || or a logger for sth
	}

}
