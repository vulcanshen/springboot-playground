package vulcan.springboot.grafana_eco;

import org.springframework.data.repository.CrudRepository;

public interface DbLogRepository extends CrudRepository<LogEntity, Long> {
}
