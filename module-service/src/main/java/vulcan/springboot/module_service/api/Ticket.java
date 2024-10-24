package vulcan.springboot.module_service.api;


import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vulcan.springboot.module_service.entity.Token;
import vulcan.springboot.module_service.repository.TokenRepository;

@RestController
@RequestMapping("/${module-service.api-prefix}/ticket")
public class Ticket {


    @Setter(onMethod_ = @Autowired)
    private TokenRepository tokenRepository;


    @PutMapping("/generate/{userId}")
    @Transactional
    public ResponseEntity<?> generate(@PathVariable("userId") String userId) {
        var token = new Token();
        token.setUserId(userId);
        tokenRepository.save(token);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(tokenRepository.findAll());
    }


}
