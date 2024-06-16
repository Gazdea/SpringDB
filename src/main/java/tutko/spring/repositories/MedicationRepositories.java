package tutko.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tutko.spring.entity.MedicationEntity;

public interface MedicationRepositories extends JpaRepository<MedicationEntity, Integer> {
}
