package info.kpfu.ru.repository;

import info.kpfu.ru.exceptions.DBException;
import info.kpfu.ru.utils.DB;

import java.util.List;

public class Identification {


    public static boolean identify(String login, String pass){
        try{

            List<String[]> users = DB.getAllUsers();
            int i =0;
            while(i < users.size()) {
                if((login.equalsIgnoreCase(users.get(i)[0])) && (pass.equalsIgnoreCase(users.get(i)[1]))){
                    return true;
                }
                i++;
            }
        }catch (DBException e){
            e.getMessage();
        }
        return false;
    }
}
