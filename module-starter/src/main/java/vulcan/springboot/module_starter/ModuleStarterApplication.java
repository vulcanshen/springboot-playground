package vulcan.springboot.module_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ModuleStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleStarterApplication.class, args);
	}

}
