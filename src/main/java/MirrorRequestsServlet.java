import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorRequestsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String,Object> pageVariables = createPageVariablesMap(request);
        //pageVarisbles.put("message", "");
        String message = request.getParameter("key");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }


        pageVariables.put("message", message == null ? "" : message);

        //response.getWriter().println(PageGenerator.instance().getPage("mirrorPage.html",pageVariables));
        response.getWriter().println(request.getParameter("key"));

        //response.setContentType("text/html;charset=utf-8");
        //response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariablesMap(request);
        String message = request.getParameter("message");

        response.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        pageVariables.put("message", message == null ? "" : message);

        response.getWriter().println(PageGenerator.instance().getPage("mirrorPage.html", pageVariables));

    }

    private static Map<String,Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String,Object> pageVariables = new HashMap<>();
        pageVariables.put("message", request.getParameterValues("key"));
        return pageVariables;
    }
}
