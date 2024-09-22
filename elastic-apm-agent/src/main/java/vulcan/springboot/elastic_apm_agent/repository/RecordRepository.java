package vulcan.springboot.elastic_apm_agent.repository;

import org.springframework.data.repository.CrudRepository;
import vulcan.springboot.elastic_apm_agent.entity.Record;

public interface RecordRepository extends CrudRepository<Record, Long> {
}
