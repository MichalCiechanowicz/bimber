package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/login")
public class LoginServlet implements Filter {

    private static final String USER = "user";
    private static final String UNKNOWN_USER_NAME = "Unknown";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //todo before
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html");

        //servlet execution
        filterChain.doFilter(servletRequest, servletResponse);

        //to do after
        PrintWriter writer = servletResponse.getWriter();
        String userName = (String) servletRequest.getAttribute(USER);
        if (userName.matches(USER)) {
            writer.println("<br><h1>Jestes kobieta!</h1><br>");
        } else {
            writer.println("<br><h1>Jestes facetem!</h1><br>");
        }
    }
}