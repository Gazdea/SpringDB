package tutko.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tutko.spring.entity.PatientEntity;

public interface PatientRepositories extends JpaRepository<PatientEntity, Integer> {
}
