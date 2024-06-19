package tutko.spring.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutko.spring.config.SpringConfig;
import tutko.spring.dto.ComponentDTO;
import tutko.spring.service.ComponentService;

import java.io.IOException;
import java.util.List;


@WebServlet("/components")
public class ComponentServlet extends HttpServlet {
    private ComponentService componentService;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        componentService = context.getBean(ComponentService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ComponentDTO> components = null;
        components = componentService.getComponents();
        request.setAttribute("components", components);
        request.getRequestDispatcher("/components.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ComponentDTO componentDTO = new ComponentDTO();
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                componentDTO.setName(request.getParameter("addname"));
                componentDTO.setDescription(request.getParameter("adddescription"));
                componentService.saveComponent(componentDTO);
                response.sendRedirect("/components");
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
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setComponentId(Integer.parseInt(req.getParameter("updateid")));
        componentDTO.setName(req.getParameter("updatename"));
        componentDTO.setDescription(req.getParameter("updatedescription"));
        componentService.saveComponent(componentDTO);
        resp.sendRedirect("/components");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int componentId = Integer.parseInt(req.getParameter("componentId"));
        componentService.deleteComponent(componentId);
        resp.sendRedirect("/components");
    }
}
