package vulcan.springboot.module_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vulcan.springboot.module_service.entity.Token;

public interface TokenRepository extends JpaRepository<Token, String> {
}
