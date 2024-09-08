package vulcan.springboot.opentelemetry.javaagent;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping(value = "/logs", consumes = "application/json")
    public ResponseEntity<?> createLog(@RequestBody HashMap<String, Object> body) {
        log.warn("application log on api [{}]", body.toString());
        return ResponseEntity.ok(body);
    }
}
