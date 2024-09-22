package vulcan.springboot.event_listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ControllerListener {

    private static int counter = 0;

    @EventListener(ApplicationEvent.class)
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("({}) trigger event on [@Controller]:{}", (++counter), event.getClass().getSimpleName());
    }
}
