package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Random;


@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @Setter(onMethod_ = @Autowired)
    DbLogService dbLogService;

    @PostMapping(value = "/logs", consumes = "application/json")
    public ResponseEntity<?> createLog() {
        var string = randomString(20);
        log.warn("application log on api [{}]", string);
        return ResponseEntity.ok(string);
    }

    public String randomString(int count) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(count)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @GetMapping(value = "/error")
    public ResponseEntity<?> throwError() {
        throw new RuntimeException("error");
    }

    @PutMapping(value = "/db")
    public ResponseEntity<?> insertDb() {
        var newLog = dbLogService.appendLog();
        return ResponseEntity.ok(newLog);
    }

    @GetMapping(value = "/proxy")
    public ResponseEntity<?> callMockAPI() {

        var callOut = RestClient.create()
                .get()
                .uri("https://66d5d01ef5859a7042678c19.mockapi.io/api/v1/users")
                .retrieve()
                .toEntity(Object.class);

        log.info("call mock api");

        return ResponseEntity.ok(callOut);
    }
}
