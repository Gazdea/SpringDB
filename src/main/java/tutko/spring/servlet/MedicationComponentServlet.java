package tutko.spring.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.MedicationComponentDTO;
import tutko.spring.service.MedicationComponentService;

import java.io.IOException;
@WebServlet("/medicationss")
public class MedicationComponentServlet extends HttpServlet {
    private MedicationComponentService medComponentService;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        medComponentService = context.getBean(MedicationComponentService.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MedicationComponentDTO medComponentDTO = new MedicationComponentDTO();
        String action = request.getParameter("action");
        switch (action) {
            case "addcomponent":
                medComponentDTO.setMedicationId(Integer.parseInt(request.getParameter("addmedicamentid")));
                medComponentDTO.setComponentId(Integer.parseInt(request.getParameter("addcomponentid")));
                medComponentService.saveMedicationComponent(medComponentDTO);
                response.sendRedirect("/medications");
                break;
            case "deletecomponent":
                doDelete(request, response);
                break;
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int medicationId = (Integer.parseInt(req.getParameter("deletemedication_id")));
        int componentId = (Integer.parseInt(req.getParameter("deletecomponent_id")));
        medComponentService.deleteMedicationComponent(medicationId, componentId);
        resp.sendRedirect("/medications");
    }
}
