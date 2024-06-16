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
import tutko.spring.dto.PrescriptionDTO;
import tutko.spring.service.PrescriptionService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrescriptionServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    PrescriptionService prescriptionService;
    @InjectMocks
    PrescriptionServlet prescriptionServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoGet() throws ServletException, IOException, SQLException {
        List<PrescriptionDTO> prescriptions = new ArrayList<>();
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionID(1);
        prescriptionDTO.setPatient_id(1);
        prescriptionDTO.setMedicine_id(1);
        prescriptionDTO.setDate_of_prescribed(new Date(1234));
        prescriptionDTO.setDosage("dosage");
        prescriptions.add(prescriptionDTO);

        when(prescriptionService.getPrescriptions()).thenReturn(prescriptions);
        when(request.getRequestDispatcher("/prescriptions.jsp")).thenReturn(dispatcher);

        prescriptionServlet.doGet(request, response);

        verify(request).setAttribute("prescriptions", prescriptions);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPost() throws IOException, SQLException {
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("addpatientID")).thenReturn("1");
        when(request.getParameter("addmedicationID")).thenReturn("1");
        when(request.getParameter("adddate_of_prescribed")).thenReturn("2024-06-07");
        when(request.getParameter("adddosage")).thenReturn("dosage");

        prescriptionServlet.doPost(request, response);

        verify(prescriptionService).savePrescription(any(PrescriptionDTO.class));
        verify(response).sendRedirect("/prescriptions");
    }

    @Test
    void testDoPut() throws IOException, SQLException {
        when(request.getParameter("updateprescriptionID")).thenReturn("1");
        when(request.getParameter("updatepatientID")).thenReturn("1");
        when(request.getParameter("updatemedicationID")).thenReturn("1");
        when(request.getParameter("updatedate_of_prescribed")).thenReturn("2024-06-07");
        when(request.getParameter("updatedosage")).thenReturn("dosage");

        prescriptionServlet.doPut(request, response);

        verify(prescriptionService).savePrescription(any(PrescriptionDTO.class));
    }

    @Test
    void testDoDelete() throws IOException, SQLException {
        when(request.getParameter("prescription_id")).thenReturn("1");

        prescriptionServlet.doDelete(request, response);

        verify(prescriptionService).deletePrescriptionById(1);
        verify(response).sendRedirect("/prescriptions");
    }
}