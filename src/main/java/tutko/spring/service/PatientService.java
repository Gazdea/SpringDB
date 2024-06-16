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

    @Autowired
    private PatientRepositories patientRepositories;

    public PatientDTO getPatientById(int id) {
        return PatientMapper.toDTO(patientRepositories.getReferenceById(id));
    }

    public List<PatientDTO> getPatients() {
        return PatientMapper.toDTO(patientRepositories.findAll());
    }

    public PatientDTO savePatient(PatientDTO patientDTO) {
        return PatientMapper.toDTO(patientRepositories.save(PatientMapper.toEntity(patientDTO)));
    }

    public void deletePatient(int id) {
        patientRepositories.deleteById(id);
    }
}
