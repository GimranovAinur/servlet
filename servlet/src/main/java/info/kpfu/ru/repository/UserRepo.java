package info.kpfu.ru.repository;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.exceptions.InvalidLogPassException;
import info.kpfu.ru.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserRepo {


    public static void addUser(User user) throws DBException, SQLException, InvalidLogPassException {

        checkUserEmail(user.getMail());
        checkUserPassword(user.getPwd());
        Connection conn = Database.getConnection();
        StringBuilder s = new StringBuilder("insert into users(email,password,sex,subscription,about)")
                .append(" values (?,?,?,?,?);");

        PreparedStatement p = conn.prepareStatement(s.toString());
        p.setString(1,user.getMail());
        p.setString(2,user.getPwd());
        p.setString(3, user.getSex());
        p.setString(4, user.getChb());
        p.setString(5, user.getInfo());
        p.executeUpdate();
    }

    public static User getUserByEmail(String email) throws SQLException, DBException {
        Connection conn = Database.getConnection();
        StringBuilder s = new StringBuilder("select * from users where email = ?;");
        PreparedStatement p = conn.prepareStatement(s.toString());
        p.setString(1,email);
        ResultSet set = p.executeQuery();

        if (set.next()){
            int id      = set.getInt(1);
            String mail     = set.getString(2);
            String pass  = set.getString(3);
            String sex   = set.getString(4);
            String subs  = set.getString(5);
            String about = set.getString(6);
            return new User(id,mail,pass,sex,subs,about);
        }
        return null;
    }
    public static User getUserById(int id) throws SQLException, DBException {

        Connection conn = Database.getConnection();
        String s = "select * from users where id = ?;";
        PreparedStatement p = conn.prepareStatement(s.toString());
        p.setInt(1, id);

        ResultSet set = p.executeQuery();

        if (set.next()){
            int uID      = set.getInt(1);
            String mail     = set.getString(2);
            String pass     = set.getString(3);
            String sex   = set.getString(4);
            String subs  = set.getString(5);
            String info = set.getString(6);
            return new User(uID,mail,pass,sex,subs,info);
        }
        return null;
    }

    private static void checkUserEmail(String email) throws InvalidLogPassException {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\.\\+-]{1,63})" +
                "@([a-zA-Z0-9-]+\\.[a-zA-Z]{2,})$");
        if (!pattern.matcher(email).matches()){
            throw new InvalidLogPassException("Email is not valid!");
        }
    }


    private static void checkUserPassword(String password) throws InvalidLogPassException {
        if (password.length() < 4 || password.length() > 24){
            throw new InvalidLogPassException("Password is not valid: it must contain from 4 to 24 symbols");
        }
    }
}
