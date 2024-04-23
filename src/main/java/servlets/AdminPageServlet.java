package servlets;

import userServer.UserServerImplement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminPageServlet extends HttpServlet {

    public static final String PAGE_URL = "/admin";
    private final UserServerImplement accountServer;

    public AdminPageServlet(UserServerImplement accountServer) {
        this.accountServer = accountServer;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        int limit = accountServer.getUsersLimit();

        response.getWriter().println(limit);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}