package tutko.spring.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tutko.spring.dto.MedicalRecordDTO;
import tutko.spring.entity.MedicalRecordEntity;
import tutko.spring.repositories.MedicalRecordRepositories;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

    @InjectMocks
    private MedicalRecordService medicalRecordService;
    @Mock
    private MedicalRecordRepositories medicalRecordRepositories;

    @Test
    void getMedicalRecord(){
        List<MedicalRecordEntity> medicalRecordEntities = new ArrayList<>();
        medicalRecordEntities.add(new MedicalRecordEntity());

        when(medicalRecordRepositories.findAll()).thenReturn(medicalRecordEntities);
        List<MedicalRecordDTO> result = medicalRecordService.getMedicalRecords();

        assertEquals(medicalRecordEntities.size(), result.size());
    }

    @Test
    void save() {
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecordDetails("test");
        medicalRecordService.saveMedicalRecord(medicalRecordDTO);
        verify(medicalRecordRepositories,times(1)).save(any(MedicalRecordEntity.class));
    }

    @Test
    void deleteMedicalRecord() {
        int id = 1;
        medicalRecordService.deleteMedicalRecord(id);
        verify(medicalRecordRepositories,times(1)).deleteById(id);
    }

}