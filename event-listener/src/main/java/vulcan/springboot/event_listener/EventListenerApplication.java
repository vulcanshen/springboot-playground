package vulcan.springboot.event_listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class EventListenerApplication {

	private static int counter = 0;

	public static void main(String[] args) {
		SpringApplication.run(EventListenerApplication.class, args);
	}


	@EventListener(SpringApplicationEvent.class)
	public void onApplicationEvent(ApplicationEvent event) {
        log.info("({}) trigger event on [@SpringBootApplication]:{}", (++counter), event.getClass().getSimpleName());
	}
}
