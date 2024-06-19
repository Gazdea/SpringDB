package tutko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutko.spring.dto.PatientDTO;
import tutko.spring.dto.PatientMapper;
import tutko.spring.entity.PatientEntity;
import tutko.spring.repositories.PatientRepositories;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepositories patientRepositories;

    @Autowired
    public PatientService(PatientRepositories patientRepositories) {
        this.patientRepositories = patientRepositories;
    }

    public PatientDTO getPatientById(int id) {
        return new PatientMapper().toDTO(patientRepositories.getReferenceById(id));
    }

    public List<PatientDTO> getPatients() {
        return new PatientMapper().toDTO(patientRepositories.findAll());
    }

    public PatientDTO savePatient(PatientDTO patientDTO) {
        return new PatientMapper().toDTO(patientRepositories.save(new PatientMapper().toEntity(patientDTO)));
    }

    public void deletePatient(int id) {
        patientRepositories.deleteById(id);
    }
}
