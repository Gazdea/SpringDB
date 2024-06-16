package tutko.spring.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.MedicalRecordDTO;
import tutko.spring.service.MedicalRecordService;

import java.io.IOException;

import java.util.List;


@WebServlet("/medicalrecords")
public class MedicalRecordServlet extends HttpServlet {
    private MedicalRecordService medicalRecordService;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        medicalRecordService = (MedicalRecordService) context.getBean("medicalRecordService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MedicalRecordDTO> medicalRecords = null;
        medicalRecords = medicalRecordService.getMedicalRecords();
        request.setAttribute("medicalrecords", medicalRecords);
        request.getRequestDispatcher("/medicalrecords.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                medicalRecordDTO.setPatient_id(Integer.parseInt(request.getParameter("patient_id")));
                medicalRecordDTO.setRecord_details(request.getParameter("record_details"));
                medicalRecordService.saveMedicalRecord(medicalRecordDTO);

                response.sendRedirect("/medicalrecords");
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
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setRecord_id(Integer.parseInt(req.getParameter("updaterecord_id")));
        medicalRecordDTO.setPatient_id(Integer.parseInt(req.getParameter("updatepatient_id")));
        medicalRecordDTO.setRecord_details(req.getParameter("updaterecord_details"));
        medicalRecordService.saveMedicalRecord(medicalRecordDTO);

        resp.sendRedirect("/medicalrecords");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int recordId = Integer.parseInt(req.getParameter("recordId"));
        medicalRecordService.deleteMedicalRecord(recordId);
        resp.sendRedirect("/medicalrecords");
    }
}
