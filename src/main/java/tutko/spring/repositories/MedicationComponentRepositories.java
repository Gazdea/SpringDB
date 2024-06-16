package tutko.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tutko.spring.entity.MedicationComponentEntity;

public interface MedicationComponentRepositories extends JpaRepository<MedicationComponentEntity, Integer> {
}
