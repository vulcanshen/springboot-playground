package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.Random;


@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @Setter(onMethod_ = @Autowired)
    DbLogService dbLogService;

    @Setter(onMethod_ = @Autowired)
    Utils utils;

    @Setter(onMethod_ = @Autowired)
    BuggyService buggyService;

    @PostMapping(value = "/logs")
    public ResponseEntity<?> createLog() {
        var string = utils.randomString(20);
        log.warn("application log on api [{}]", string);
        return ResponseEntity.ok(string);
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

    @PostMapping(value = "/bugs")
    public ResponseEntity<?> createBugs() {
        return ResponseEntity.ok(buggyService.create());
    }

    @DeleteMapping(value = "/bugs")
    public ResponseEntity<?> deleteBugs() {
        return ResponseEntity.ok(buggyService.pop());
    }
}
