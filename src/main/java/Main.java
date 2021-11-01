import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servlets.GreetingServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start main class");
        Server server = new Server(8080);
        ServletHandler webapp = new ServletHandler();
        webapp.addServletWithMapping(GreetingServlet.class ,"/");
        server.setHandler(webapp);
        server.start();
        System.out.println("Server: "+ server.getState());
        server.join();
    }
}
