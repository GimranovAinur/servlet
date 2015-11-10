package info.kpfu.ru.servlets;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.*;
import info.kpfu.ru.repository.UserRepo;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("current_user") != null){
            resp.sendRedirect("/main");
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String email = req.getParameter("mail");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String chb = req.getParameter("chb") == null ? "off":"on";
        String info = req.getParameter("about");
        try{
            User user = new User(email, pwd, sex, chb, info);
            UserRepo.addUser(user);
            HttpSession session = req.getSession(true);
            session.setAttribute("current_user",user);
            session.setMaxInactiveInterval(5*60);
            Cookie c = new Cookie("current_user",req.getParameter("login"));
            resp.addCookie(c);
            resp.sendRedirect("/main");
            return;
        }
        catch(DBException ex){
            req.setAttribute("message", "Error with DB has been occured.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidLogPassException e) {
            e.printStackTrace();
        }
    }
}
