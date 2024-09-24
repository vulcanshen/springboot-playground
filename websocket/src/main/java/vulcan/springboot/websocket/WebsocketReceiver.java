package vulcan.springboot.websocket;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketReceiver {

    @Autowired
    private BroadcastService broadcastService;

    @MessageMapping("/info")
    public void onMessage(String message) {
        broadcastService.getMessages().add(message);
        broadcastService.broadcast();
    }
}
