package vulcan.springboot.module_starter.scheudler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class TimerScheduler {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        log.info("The time is now {}", formatter.format(LocalDateTime.now()));
    }
}
