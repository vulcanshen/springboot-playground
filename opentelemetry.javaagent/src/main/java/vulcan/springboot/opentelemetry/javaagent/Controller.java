package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;


@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @Setter(onMethod_ = @Autowired)
    DbLogService dbLogService;

    @Setter(onMethod_ = @Autowired)
    Utils utils;


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

    @GetMapping(value = "/fib/{n}")
    public ResponseEntity<?> fib(@PathVariable("n") long n) {
        return ResponseEntity.ok(utils.fib(n));
    }

}
