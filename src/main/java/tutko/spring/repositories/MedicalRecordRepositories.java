package tutko.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tutko.spring.entity.MedicalRecordEntity;

public interface MedicalRecordRepositories extends JpaRepository<MedicalRecordEntity, Integer> {
}
