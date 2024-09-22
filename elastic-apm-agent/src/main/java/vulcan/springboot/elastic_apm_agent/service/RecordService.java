package vulcan.springboot.elastic_apm_agent.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vulcan.springboot.elastic_apm_agent.entity.Record;
import vulcan.springboot.elastic_apm_agent.repository.RecordRepository;

import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    RecordRepository userRepository;

    public Record save(Record user) {
        return userRepository.save(user);
    }

    public Optional<Record> findById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<Record> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Record update(Record record) {
        return userRepository.save(record);
    }
}
