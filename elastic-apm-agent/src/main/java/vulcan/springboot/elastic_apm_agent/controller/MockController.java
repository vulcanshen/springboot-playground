package vulcan.springboot.elastic_apm_agent.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/mock")
public class MockController {


    @GetMapping("/users")
    public ResponseEntity<?> users() {
        var client = RestClient.create();
        var resp = client.get()
                .uri("https://66ced81d901aab24841fce90.mockapi.io/api/v1/users")
                .retrieve()
                .body(Object.class);

        return ResponseEntity.ok(resp);
    }


}
