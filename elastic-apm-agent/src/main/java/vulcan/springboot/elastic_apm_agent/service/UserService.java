package vulcan.springboot.elastic_apm_agent.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vulcan.springboot.elastic_apm_agent.entity.User;
import vulcan.springboot.elastic_apm_agent.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        return userRepository.save(user);
    }
}
