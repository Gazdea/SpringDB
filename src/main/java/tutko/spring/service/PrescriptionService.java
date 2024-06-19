package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.PrescriptionDTO;
import tutko.spring.dto.PrescriptionMapper;
import tutko.spring.entity.PrescriptionEntity;
import tutko.spring.repositories.PrescriptionRepositories;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepositories prescriptionRepositories;

    @Autowired
    public PrescriptionService(PrescriptionRepositories prescriptionRepositories) {
        this.prescriptionRepositories = prescriptionRepositories;
    }

    public PrescriptionDTO getPrescriptionById(int id) {
        return new PrescriptionMapper().toDTO(prescriptionRepositories.getReferenceById(id));
    }

    public List<PrescriptionDTO> getPrescriptions() {
        return new PrescriptionMapper().toDTO(prescriptionRepositories.findAll());
    }

    public PrescriptionDTO savePrescription(PrescriptionDTO prescriptionDTO) {
        return new PrescriptionMapper().toDTO(prescriptionRepositories.save(new PrescriptionMapper().toEntity(prescriptionDTO)));
    }

    public void deletePrescriptionById(int id) {
        prescriptionRepositories.deleteById(id);
    }
}
