package tutko.spring.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.MedicationDTO;
import tutko.spring.service.MedicationService;

import java.io.IOException;
import java.util.List;

@WebServlet("/medications/*")
public class MedicationServlet extends HttpServlet {
    private MedicationService medicationService;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        medicationService = (MedicationService) context.getBean("medicationService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MedicationDTO> medications = null;
        medications = medicationService.getMedications();
        request.setAttribute("medications", medications);
        request.getRequestDispatcher("/medications.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            MedicationDTO medicationDTO = new MedicationDTO();
            String action = request.getParameter("action");
            switch (action) {
                case "add":
                    medicationDTO.setName(request.getParameter("name"));
                    medicationDTO.setDescription(request.getParameter("description"));
                    medicationService.saveMedication(medicationDTO);
                    response.sendRedirect("/medications");
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
        MedicationDTO medicationDTO = new MedicationDTO();
        medicationDTO.setMedicationId(Integer.parseInt(req.getParameter("updatemedicationId")));
        medicationDTO.setName(req.getParameter("updatename"));
        medicationDTO.setDescription(req.getParameter("updatedescription"));
        medicationService.saveMedication(medicationDTO);
        resp.sendRedirect("/medications");
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int medicationId = Integer.parseInt(req.getParameter("medicationId"));
        medicationService.deleteMedicationById(medicationId);
        resp.sendRedirect("/medications");
    }
}
