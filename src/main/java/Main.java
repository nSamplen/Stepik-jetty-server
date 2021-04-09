import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {

        //обработчик
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        MirrorRequestsServlet mirrorRequestsServlet = new MirrorRequestsServlet();

        ServletContextHandler contex =
                new ServletContextHandler(ServletContextHandler.SESSIONS);

        contex.addServlet(new ServletHolder(mirrorRequestsServlet), "/mirror");
        contex.addServlet(new ServletHolder(allRequestsServlet), "/*");

        //jetty сервер
        Server server = new Server(8080);
        server.setHandler(contex);

        server.start();
        //System.out.println("Server started");
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
