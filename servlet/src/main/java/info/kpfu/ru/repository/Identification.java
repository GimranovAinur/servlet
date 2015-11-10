package info.kpfu.ru.repository;

import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.DBException;

import java.sql.*;

public class Identification {


    public static boolean identify(String login, String pass) throws SQLException, DBException {
        User user = UserRepo.getUserByEmail(login);
        if(user != null && user.getPwd().equals(pass)){
            return true;
        }else{
            return false;
        }
    }
}
