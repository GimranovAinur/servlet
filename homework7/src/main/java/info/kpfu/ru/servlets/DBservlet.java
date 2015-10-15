package info.kpfu.ru.servlets;

import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.utils.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DBservlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        try {
            req.setAttribute("users", DB.getAllUsers());
        } catch (DBException dbException) {
            dbException.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/table.jsp").forward(req, resp);
    }
}
