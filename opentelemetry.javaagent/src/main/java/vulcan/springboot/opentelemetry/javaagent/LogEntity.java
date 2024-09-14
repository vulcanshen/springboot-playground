package vulcan.springboot.opentelemetry.javaagent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logs")
public class LogEntity {

    @Id
    @GeneratedValue
    private long id;
    private String uuid;

    @Builder.Default
    private LocalDateTime createTime = LocalDateTime.now();
}
