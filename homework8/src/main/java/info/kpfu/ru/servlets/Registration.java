package info.kpfu.ru.servlets;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.*;
import info.kpfu.ru.repository.UserRepo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getParameter("status") != null){
            if(req.getParameter("status").equals("1")){
                req.setAttribute("message", "User has been created.");
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String email = req.getParameter("mail");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String chb = req.getParameter("chb");
        try{
            User user = new User(email, pwd, sex, chb);
            UserRepo.addUserToList(user);
            resp.sendRedirect(req.getRequestURI()+"?status=1");
            return;
        }
        catch(DBException ex){
            req.setAttribute("message", "Error with DB has been occured.");
        }
        catch(duplicateException ex){
            req.setAttribute("message", "User with such email already exists.");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }
}
