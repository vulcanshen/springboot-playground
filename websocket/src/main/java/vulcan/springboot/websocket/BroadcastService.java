package vulcan.springboot.websocket;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
@Component
public class BroadcastService {

    private final List<String> messages = new ArrayList<>();

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    public void broadcast() {
        template.convertAndSend("/topic/broadcast", Map.of(
                "local_date_time", LocalDateTime.now(),
                "messages", messages
        ));
    }

}
