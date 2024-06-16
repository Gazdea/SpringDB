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

    @Autowired
    private PrescriptionRepositories prescriptionRepositories;

    public PrescriptionDTO getPrescriptionById(int id) {
        return PrescriptionMapper.toDTO(prescriptionRepositories.getReferenceById(id));
    }

    public List<PrescriptionDTO> getPrescriptions() {
        return PrescriptionMapper.toDTO(prescriptionRepositories.findAll());
    }

    public PrescriptionDTO savePrescription(PrescriptionDTO prescriptionDTO) {
        return PrescriptionMapper.toDTO(prescriptionRepositories.save(PrescriptionMapper.toEntity(prescriptionDTO)));
    }

    public void deletePrescriptionById(int id) {
        prescriptionRepositories.deleteById(id);
    }
}
