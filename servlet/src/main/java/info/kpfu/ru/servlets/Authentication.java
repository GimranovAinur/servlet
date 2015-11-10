package info.kpfu.ru.servlets;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.repository.Identification;
import info.kpfu.ru.repository.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("status")!=null){
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies){
                    if (cookie.getName().equals("current_user")){
                        cookie.setMaxAge(0);
                        cookie.setValue(null);
                        resp.addCookie(cookie);
                        break;
                    }
                }
            }
            session.setAttribute("current_user", null);
        }
        if(session.getAttribute("current_user") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/views/LogInJsp.jsp").forward(req, resp);
        } else {
            session.setAttribute("current_user",new User(req.getParameter("login"),req.getParameter("pass")));
            session.setMaxInactiveInterval(60);
            resp.sendRedirect("/main");
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        try {
            if (Identification.identify(login, pass)){
                HttpSession session = req.getSession();
                User user = UserRepo.getUserByEmail(login);
                session.setAttribute("current_user",user);
                session.setMaxInactiveInterval(5*60);
                Cookie[] cookies = req.getCookies();
                if(cookies == null) {
                    Cookie c = new Cookie("current_user", req.getParameter("login"));
                    resp.addCookie(c);
                    if(req.getParameter("chb").equals("on")){
                        c.setMaxAge(5 * 60 * 60);
                    }
                    resp.sendRedirect("http://localhost:8080/main");
                }else{
                    resp.sendRedirect("http://localhost:8080/main");
                }
            }else{
                req.setAttribute("alert",true);
                getServletContext().getRequestDispatcher("/WEB-INF/views/LogInJsp.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
