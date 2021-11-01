package servlets;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;


@WebServlet(value = "/user")
public class GreetingServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("application/json");
        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println(service.getUser());
        }
        System.out.println("doGet");
        //TODO: HTTP GET запрос
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doPost");
        try (PrintWriter writer = resp.getWriter()) {
            JSONObject json = getJsonObject(req);
            service.addUser(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: HTTP POST запрос
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doPut");
        try (PrintWriter writer = resp.getWriter()) {
            JSONObject json = getJsonObject(req);
            service.putUser(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: HTTP PUT запрос
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doDelete");
        try (PrintWriter writer = resp.getWriter()) {
            JSONObject json = getJsonObject(req);
            service.deleteUser(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: HTTP DELETE запрос
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
        super.init(config);
        service.init();
    }

    private JSONObject getJsonObject(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        JSONObject json = new JSONObject(sb.toString());
        System.out.println("doPost "+ json);
        return json;
    }
}
