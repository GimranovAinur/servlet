package info.kpfu.ru.repository;


import info.kpfu.ru.entity.Post;
import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.utils.Database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostRepo {

    public static int addPost(Post post) throws SQLException, DBException {

        StringBuilder s = new StringBuilder("insert into posts(text,date,user_id)")
                .append("values(?, ?, ?);");

        PreparedStatement p = Database.getConnection().prepareStatement(s.toString(), Statement.RETURN_GENERATED_KEYS);

        p.setNString(1, post.getText());

        p.setString(2, post.getPub_date());
        p.setInt(3, post.getUser_id());

        p.executeUpdate();

        ResultSet set = p.getGeneratedKeys();
        if (set.next()){
            return set.getInt(1);
        }
        return -1;
    }

    public static List<Post> getAllPosts() throws DBException,SQLException {

        ResultSet set = Database.getConnection().createStatement()
                .executeQuery("select * from posts");

        List<Post> posts = new LinkedList<>();
        while (set.next()){
            int id      = set.getInt(1);
            String text = set.getString(2);
            Date date   = set.getDate(3);
            Time time   = set.getTime(3);
            int user_id = set.getInt(4);

            Post post = new Post(id,text,date.toString()+"  " + time.toString(),user_id);
            User user = UserRepo.getUserById(user_id);
            if (user != null){
                post.setUser_name(user.getMail());
                posts.add(post);
            }
        }
        return posts;
    }
}
