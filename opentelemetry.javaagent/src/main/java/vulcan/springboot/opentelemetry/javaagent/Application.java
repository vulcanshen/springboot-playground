package vulcan.springboot.opentelemetry.javaagent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(SpringApplicationEvent.class)
	public void onEvent(SpringApplicationEvent event) {
		log.info("application log [{}] from [{}]", event.getClass().getSimpleName(), getClass().getName());
	}

}
