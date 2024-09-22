package vulcan.springboot.event_listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ComponentListener {

    private static int counter = 0;

    @EventListener(ApplicationEvent.class)
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("({}) trigger event on [@Component]:{}", (++counter), event.getClass().getSimpleName());
    }
}
