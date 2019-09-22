package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    public static final String PRIVILAGE = "privilage";
    public static final String ADMIN_PRIVILAGE = "admin privilage";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String user = request.getParameter(USER);
        String password = request.getParameter(PASSWORD);

        if (ADMIN_USER.equals(user) && ADMIN_PASSWORD.equals(password)) {
            setAdminPrivilege(request);
            writer.println("Succesfull");
            request.getRequestDispatcher("/index.jsp").include(request,response);
        } else {
            writer.println("Wrong login or password");
        }
    }

    private void setAdminPrivilege(HttpServletRequest request) {
        //session
        HttpSession session = request.getSession();
        session.setAttribute(PRIVILAGE, ADMIN_PRIVILAGE);
    }

    private void setAdminPrivilegeCookie(HttpServletResponse response) {
        //cookie
        Cookie cookie = new Cookie(PRIVILAGE, ADMIN_PRIVILAGE);
        response.addCookie(cookie);
    }
}