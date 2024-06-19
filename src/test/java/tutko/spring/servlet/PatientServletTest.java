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
import tutko.spring.dto.PatientDTO;
import tutko.spring.service.PatientService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private PatientService patientService;
    @InjectMocks
    private PatientServlet patientServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoGet() throws ServletException, IOException, SQLException, ParseException {
        List<PatientDTO> patientDTOList = new ArrayList<>();
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientId(1);
        patientDTO.setName("John");
        patientDTO.setBirthDate(new Date(1234));
        patientDTOList.add(patientDTO);

        when(patientService.getPatients()).thenReturn(patientDTOList);
        when(request.getRequestDispatcher("/patients.jsp")).thenReturn(dispatcher);

        patientServlet.doGet(request, response);

        verify(request).setAttribute("patients", patientDTOList);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPost() throws IOException, SQLException, ParseException {
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("addname")).thenReturn("John");
        when(request.getParameter("addbirth_date")).thenReturn("1990-01-01");

        patientServlet.doPost(request, response);

        verify(patientService).savePatient(any(PatientDTO.class));
        verify(response).sendRedirect("/patients");
    }

    @Test
    void testDoPut() throws IOException, SQLException, ParseException {
        when(request.getParameter("updatepatientId")).thenReturn("1");
        when(request.getParameter("updatename")).thenReturn("John");
        when(request.getParameter("updatebirth_date")).thenReturn("1990-01-01");

        patientServlet.doPut(request, response);

        verify(patientService).savePatient(any(PatientDTO.class));
        verify(response).sendRedirect("/patients");
    }

    @Test
    void testDoDelete() throws IOException, SQLException {
        when(request.getParameter("patientId")).thenReturn("1");

        patientServlet.doDelete(request, response);

        verify(patientService).deletePatient(1);
        verify(response).sendRedirect("/patients");
    }
}