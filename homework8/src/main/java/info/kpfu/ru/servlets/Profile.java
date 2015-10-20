package info.kpfu.ru.servlets;


import info.kpfu.ru.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        User user =(User) session.getAttribute("current_user");
        if(user == null) {
            req.setAttribute("message","Please, Log In");
            resp.sendRedirect("http://localhost:8080/login");
        } else {
            Cookie[] cookies = req.getCookies();
            req.setAttribute("cookie",cookies);
            getServletContext().getRequestDispatcher("/WEB-INF/views/Profile.jsp").forward(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        this.doGet(req, resp);
    }
}
