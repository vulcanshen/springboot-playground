package vulcan.springboot.elastic_apm_agent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vulcan.springboot.elastic_apm_agent.entity.User;
import vulcan.springboot.elastic_apm_agent.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    public record PostParam(String name) {}

    @Autowired
    UserService service;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> create(@RequestBody PostParam body) {
        var newUser = User.builder().name(body.name).build();
        newUser = service.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody PostParam body) {
        var user = service.findById(id).orElseThrow();
        user.setName(body.name);
        user = service.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
