package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static controller.LoginServlet.ADMIN_PRIVILAGE;
import static controller.LoginServlet.PRIVILAGE;

@WebFilter(filterName = "AdminFillter", urlPatterns = {"/product"})
public class AdminFillter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //before
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        String privilage = (String) session.getAttribute(PRIVILAGE);
        //action
        if(ADMIN_PRIVILAGE.equals(privilage)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            servletResponse.setContentType("text/html");
            PrintWriter writer = servletResponse.getWriter();
            writer.println("no access");
            servletRequest.getRequestDispatcher("/index.jps").include(servletRequest,servletResponse);
        }
        //after
    }
}
