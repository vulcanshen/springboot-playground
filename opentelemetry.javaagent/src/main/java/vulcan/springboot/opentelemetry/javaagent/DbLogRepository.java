package vulcan.springboot.opentelemetry.javaagent;

import org.springframework.data.repository.CrudRepository;

public interface DbLogRepository extends CrudRepository<LogEntity, Long> {
}
