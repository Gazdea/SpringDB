package tutko.spring.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.PatientDTO;
import tutko.spring.service.PatientService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/patients")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        patientService = (PatientService) context.getBean("patientService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PatientDTO> patients = null;
        patients = patientService.getPatients();
        request.setAttribute("patients", patients);
            request.getRequestDispatcher("/patients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PatientDTO patientDTO = new PatientDTO();
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                patientDTO.setName(request.getParameter("addname"));
                patientDTO.setBirth_date(Date.valueOf(request.getParameter("addbirth_date")));
                patientService.savePatient(patientDTO);
                response.sendRedirect("/patients");
                break;
            case "update":
                doPut(request, response);
                break;
            case "delete":
                doDelete(request, response);
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatient_id(Integer.parseInt(req.getParameter("updatepatientId")));
        patientDTO.setName(req.getParameter("updatename"));
        patientDTO.setBirth_date(Date.valueOf(req.getParameter("updatebirth_date")));
        patientService.savePatient(patientDTO);
        resp.sendRedirect("/patients");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        patientService.deletePatient(patientId);
        resp.sendRedirect("/patients");
    }
}
