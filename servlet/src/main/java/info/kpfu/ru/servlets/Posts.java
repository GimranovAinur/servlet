package info.kpfu.ru.servlets;



import info.kpfu.ru.entity.Post;
import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.repository.PostRepo;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.StringWriter;
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
        User user = (User)session.getAttribute("current_user");
        String textForPost = req.getParameter("post");
        if ("".equals(textForPost) || textForPost == null){
            return;
        }
        Post post = new Post(textForPost,user.getId());
        post.setUser_name(user.getMail());

        try {
            int id = PostRepo.addPost(post);
            post.setId(id);
            String data = getPostJSON(post);
            if ("".equals(data)){
                return;
            }
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            resp.getWriter().write(data);

        } catch (SQLException e) {
            req.setAttribute("message","problems in server");
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    private static String getPostJSON(Post post){

        try(StringWriter sWriter  = new StringWriter()) {

            JSONObject obj = new JSONObject();

            obj.put("userName",post.getUser_name());
            obj.put("postText",post.getText());
            obj.put("postTime",post.getPub_date());
            obj.put("id",post.getId());

            obj.write(sWriter);
            return sWriter.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
