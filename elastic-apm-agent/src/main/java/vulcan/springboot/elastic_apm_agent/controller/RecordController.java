package vulcan.springboot.elastic_apm_agent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vulcan.springboot.elastic_apm_agent.entity.Record;
import vulcan.springboot.elastic_apm_agent.service.RecordService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    RecordService service;

    @PostMapping
    public ResponseEntity<Record> create() {
        var newRecord = Record.builder().build();
        newRecord = service.save(newRecord);

        return ResponseEntity.ok(newRecord);
    }

    @GetMapping
    public ResponseEntity<Iterable<Record>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> update(@PathVariable("id") Long id) {
        var record = service.findById(id).orElseThrow();
        record.setCreateTime(LocalDateTime.now());
        record = service.update(record);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
