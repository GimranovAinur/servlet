package info.kpfu.ru.servlets;



import info.kpfu.ru.entity.Post;
import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.repository.PostRepo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Posts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<Post> posts = new ArrayList<>();
        try {
            posts = PostRepo.getAllPosts();
        } catch (DBException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute("current_user");
        req.setAttribute("user",user);
        req.setAttribute("posts",posts);
        getServletContext().getRequestDispatcher("/WEB-INF/views/posts.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        HttpSession session = req.getSession();

        String postText = req.getParameter("post");
        User user =(User) session.getAttribute("current_user");
        Post post = new Post(postText,user.getId());
        post.setUser_name(user.getMail());
        try {
            PostRepo.addPost(post);
        } catch (DBException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/posts");
    }
}
