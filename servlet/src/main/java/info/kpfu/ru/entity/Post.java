package info.kpfu.ru.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    int id;
    String text;
    String pub_date;
    int user_id;
    String user_name;
    int likes_count;

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public Post(String text, int user_id) {
        this(text,currentDate(),user_id);
    }

    public Post(String text, String pub_date, int user_id) {
        this.text = text;
        this.pub_date = pub_date;
        this.user_id = user_id;
    }

    public Post(int id, String text, String pub_date, int user_id) {
        this.id = id;
        this.text = text;
        this.pub_date = pub_date;
        this.user_id = user_id;
    }

    private static String currentDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
