package vulcan.springboot.event_listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Component
public class ComponentListener {

    private static int counter = 0;

    @EventListener(ApplicationEvent.class)
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("({}) trigger event on [@Component]:{}", (++counter), event.getClass().getSimpleName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        var b64Url = "RUFQRERfSFVMWQ%3D%3D";
        var sB64 = URLDecoder.decode(b64Url, StandardCharsets.UTF_8);//Base64.getEncoder().encodeToString("EAPDD_HULY".getBytes(StandardCharsets.UTF_8));
        var secretB64 = passwordEncoder.encode(sB64);
        var secretB642 = passwordEncoder.encode(sB64);
        boolean isMatch = passwordEncoder.matches(sB64, "$2a$10$YwcGWRx.hP.Zz0Q4pfa6ie9aKJ2XeBx6QDLhdbOHWb3qH/cb4xA2u");
        log.info("secretB64:{}, secretB642: {}, isMatch:{}", sB64, secretB64, isMatch);
    }
}
