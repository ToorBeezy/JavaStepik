package servlets;

import userServer.UserServerImplement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {

    static final Logger logger = LogManager.getLogger(HomePageServlet.class.getName());
    public static final String PAGE_URL = "/home";
    private final UserServerImplement userServer;

    public HomePageServlet(UserServerImplement userServer) {
        this.userServer = userServer;
    }

    public void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String remove = request.getParameter("remove");

        if (remove != null) {
            userServer.removeUser();
            response.getWriter().println("Bye!");
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        int limit = userServer.getUsersLimit();
        int count = userServer.getUsersCount();

        logger.info("Limit: {}. Count {}", limit, count);

        if (limit > count) {
            logger.info("User passed");
            userServer.addNewUser();
            response.getWriter().println("Hello, world!");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            logger.info("User were rejected");
            response.getWriter().println("Server is closed");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
