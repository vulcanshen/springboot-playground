package vulcan.springboot.grafana_eco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
