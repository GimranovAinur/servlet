package info.kpfu.ru.servlets;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.repository.Identification;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class Authentication extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String user =(String) session.getAttribute("current_user");
        if(user == null) {
            req.setAttribute("message","Please, Log In");
            getServletContext().getRequestDispatcher("/WEB-INF/views/LogInJsp.jsp").forward(req, resp);
        } else {
            session.setAttribute("current_user",req.getParameter("login"));
            session.setMaxInactiveInterval(20);
            resp.sendRedirect("http://localhost:8080/profile");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User(req.getParameter("login"),req.getParameter("pass"));
        if (Identification.identify(user.getMail(), user.getPwd())){
            HttpSession session = req.getSession(true);
            session.setAttribute("current_user",user);
            Cookie[] cookies = req.getCookies();
            if(cookies == null) {
                Cookie c = new Cookie("current_user", req.getParameter("login"));
                resp.addCookie(c);
                if(req.getParameter("chb").equals("on")){
                    c.setMaxAge(5 * 60);
                }
                resp.sendRedirect("http://localhost:8080/profile");
            }else{
                resp.sendRedirect("http://localhost:8080/profile");
            }
        }else{
            resp.sendRedirect("http://localhost:8080/registration");
        }
    }
}
