package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @Setter(onMethod_ = @Autowired)
    DbLogService dbLogService;

    @PostMapping(value = "/logs", consumes = "application/json")
    public ResponseEntity<?> createLog(@RequestBody HashMap<String, Object> body) {
        log.warn("application log on api [{}]", body.toString());
        return ResponseEntity.ok(body);
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
