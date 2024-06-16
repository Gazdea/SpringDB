package tutko.spring.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tutko.spring.config.JpaConfig;
import tutko.spring.entity.MedicalRecordEntity;

import java.util.List;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
class MedicalRecordRepositoriesTest {

    @Autowired
    private MedicalRecordRepositories medicalRecordRepositories;

    @Test
    public void testSaveAndFindMedicalRecord() {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecord_details("test");
        medicalRecordRepositories.save(medicalRecordEntity);

        MedicalRecordEntity found = medicalRecordRepositories.findById(medicalRecordEntity.getRecord_id()).orElse(null);
        assertNotNull(medicalRecordEntity);
        assertEquals(medicalRecordEntity.getRecord_details(), found.getRecord_details());
    }

    @Test
    public void findAll() {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecord_details("test");
        medicalRecordRepositories.save(medicalRecordEntity);
        List<MedicalRecordEntity> list = medicalRecordRepositories.findAll();

        assertNotNull(list);
        assertEquals(list.size(), 1);
    }

    @Test
    public void delete() {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecord_details("test");
        medicalRecordRepositories.save(medicalRecordEntity);
        medicalRecordRepositories.deleteById(medicalRecordEntity.getRecord_id());
        MedicalRecordEntity found = medicalRecordRepositories.findById(medicalRecordEntity.getRecord_id()).orElse(null);
        assertNull(found);
    }

    @Test
    public void update() {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setRecord_details("test");
        medicalRecordRepositories.save(medicalRecordEntity);

        MedicalRecordEntity found = medicalRecordRepositories.findById(medicalRecordEntity.getRecord_id()).orElse(null);
        found.setRecord_details("test2");
        medicalRecordRepositories.save(found);

        MedicalRecordEntity result = medicalRecordRepositories.findById(found.getRecord_id()).orElse(null);

        assertNotEquals(result.getRecord_details(), medicalRecordEntity.getRecord_details());
    }
}