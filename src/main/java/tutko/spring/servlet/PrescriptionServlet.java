package tutko.spring.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.PrescriptionDTO;
import tutko.spring.service.PrescriptionService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/prescriptions")
public class PrescriptionServlet extends HttpServlet {
    private PrescriptionService prescriptionService;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        prescriptionService = context.getBean(PrescriptionService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PrescriptionDTO> prescriptions = null;
        prescriptions = prescriptionService.getPrescriptions();
        request.setAttribute("prescriptions", prescriptions);
            request.getRequestDispatcher("/prescriptions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        String action = request.getParameter("action");
            switch (action) {
                case "add":
                    prescriptionDTO.setPatientId(Integer.parseInt(request.getParameter("addpatientID")));
                    prescriptionDTO.setMedicineId(Integer.parseInt(request.getParameter("addmedicationID")));
                    prescriptionDTO.setDate_of_prescribed(Date.valueOf(request.getParameter("adddateOfPrescribed")));
                    prescriptionDTO.setDosage(request.getParameter("adddosage"));
                    prescriptionService.savePrescription(prescriptionDTO);
                    response.sendRedirect("/prescriptions");
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
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionID(Integer.parseInt(req.getParameter("updateprescriptionID")));
        prescriptionDTO.setPatientId(Integer.parseInt(req.getParameter("updatepatientID")));
        prescriptionDTO.setMedicineId(Integer.parseInt(req.getParameter("updatemedicationID")));
        prescriptionDTO.setDate_of_prescribed(Date.valueOf(req.getParameter("updatedateOfPrescribed")));
        prescriptionDTO.setDosage(req.getParameter("updatedosage"));
        prescriptionService.savePrescription(prescriptionDTO);
        resp.sendRedirect("/prescriptions");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int prescriptionId = Integer.parseInt(req.getParameter("prescription_id"));
        prescriptionService.deletePrescriptionById(prescriptionId);
        resp.sendRedirect("/prescriptions");
    }
}

