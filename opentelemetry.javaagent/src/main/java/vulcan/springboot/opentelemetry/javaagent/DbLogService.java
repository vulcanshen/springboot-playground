package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Setter(onMethod_ = {@Autowired})
    private UserRepository repository;

    public UserEntity addUser(String name) {
        var newUser = UserEntity.builder()
                .name(name)
                .build();
        repository.save(newUser);
        return newUser;
    }
}
