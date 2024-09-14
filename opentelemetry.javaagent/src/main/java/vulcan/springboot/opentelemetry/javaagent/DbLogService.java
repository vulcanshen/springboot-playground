package vulcan.springboot.opentelemetry.javaagent;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbLogService {

    @Setter(onMethod_ = @Autowired)
    private DbLogRepository repository;

    public LogEntity appendLog() {
        var newLog = LogEntity.builder()
                .uuid(UUID.randomUUID().toString())
                .build();
        repository.save(newLog);
        return newLog;
    }
}
