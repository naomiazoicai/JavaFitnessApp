package map.project.FitnessCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessCenterApplication {

	public static void main(String[] args) {
		// Make sure Budget with id 1 exists in database
		SpringApplication.run(FitnessCenterApplication.class, args);
	}

}
