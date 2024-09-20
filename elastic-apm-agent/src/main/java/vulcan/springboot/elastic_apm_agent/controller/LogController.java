package vulcan.springboot.elastic_apm_agent.controller;


import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/log")
public class LogController {


    @PostMapping()
    public ResponseEntity<?> log(@RequestBody  Map<?,?> body) {
        var logger = LoggerFactory.getLogger(LogController.class);
        logger.error("@@@@@LOG@@@@@@@");

        return ResponseEntity.ok(body);
    }
}
