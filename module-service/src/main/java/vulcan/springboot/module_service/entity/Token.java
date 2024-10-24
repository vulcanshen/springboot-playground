package vulcan.springboot.module_service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;


@Data
@Entity
@Table(name = "module_service_token")
public class Token {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    @Column(name = "create_time")
    private Long createTime = System.currentTimeMillis();

    @Column(name = "expire_time")
    private Long expireTime = createTime + 1000 * 60 * 60 * 24 * 7;

    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String token;

    @Column(name = "user_id")
    private String userId;
}
