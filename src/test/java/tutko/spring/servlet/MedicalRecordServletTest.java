package tutko.spring.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tutko.spring.dto.MedicalRecordDTO;
import tutko.spring.service.MedicalRecordService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private MedicalRecordService medicalRecordService;
    @InjectMocks
    private MedicalRecordServlet medicalRecordServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoGet() throws ServletException, IOException, SQLException {
        List<MedicalRecordDTO> medicalRecordDTOList = new ArrayList<>();
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecordId(1);
        medicalRecordDTO.setPatientId(1);
        medicalRecordDTO.setRecordDetails("details");
        medicalRecordDTOList.add(medicalRecordDTO);

        when(medicalRecordService.getMedicalRecords()).thenReturn(medicalRecordDTOList);
        when(request.getRequestDispatcher("/medicalrecords.jsp")).thenReturn(dispatcher);

        medicalRecordServlet.doGet(request, response);

        verify(request).setAttribute("medicalrecords", medicalRecordDTOList);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPost() throws SQLException, IOException, ServletException {
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("patient_id")).thenReturn("1");
        when(request.getParameter("record_details")).thenReturn("details");

        medicalRecordServlet.doPost(request, response);

        verify(medicalRecordService).saveMedicalRecord(any(MedicalRecordDTO.class));
        verify(response).sendRedirect("/medicalrecords");
    }

    @Test
    void testDoPut() throws SQLException, IOException, ServletException {
        when(request.getParameter("updaterecord_id")).thenReturn("1");
        when(request.getParameter("updatepatient_id")).thenReturn("1");
        when(request.getParameter("updaterecord_details")).thenReturn("updated details");

        medicalRecordServlet.doPut(request, response);

        verify(medicalRecordService).saveMedicalRecord(any(MedicalRecordDTO.class));
        verify(response).sendRedirect("/medicalrecords");
    }

    @Test
    void testDoDelete() throws SQLException, IOException, ServletException {
        when(request.getParameter("recordId")).thenReturn("1");

        medicalRecordServlet.doDelete(request, response);

        verify(medicalRecordService).deleteMedicalRecord(1);
        verify(response).sendRedirect("/medicalrecords");
    }
}