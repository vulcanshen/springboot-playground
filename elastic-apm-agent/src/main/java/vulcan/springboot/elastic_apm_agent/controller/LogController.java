package vulcan.springboot.elastic_apm_agent.controller;


import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/logs")
public class LogController {


    @PostMapping
    public ResponseEntity<?> create() {
        var logger = LoggerFactory.getLogger(LogController.class);
        System.out.println(logger.getClass().getName());
        logger.error("@@@@@LOG@@@@@@@");

        return ResponseEntity.ok().build();
    }
}
