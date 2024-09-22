package vulcan.springboot.event_listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
public class ConfigurationListener {

    private static int counter = 0;

    @EventListener(ApplicationEvent.class)
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("({}) trigger event on [@Configuration]:{}", (++counter), event.getClass().getSimpleName());
    }
}
