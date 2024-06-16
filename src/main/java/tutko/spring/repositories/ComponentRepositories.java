package tutko.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tutko.spring.entity.ComponentEntity;

public interface ComponentRepositories extends JpaRepository<ComponentEntity, Integer> {
}
