package tutko.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tutko.spring.entity.PrescriptionEntity;

public interface PrescriptionRepositories extends JpaRepository<PrescriptionEntity, Integer> {
}
