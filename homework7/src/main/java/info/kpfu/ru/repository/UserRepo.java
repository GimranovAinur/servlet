package info.kpfu.ru.repository;


import info.kpfu.ru.entity.User;
import info.kpfu.ru.exceptions.*;
import info.kpfu.ru.utils.DB;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRepo {


    public static void addUserToList(User user) throws duplicateException, DBException {
        if (user == null){
            throw new NullPointerException("User is null");
        }

        if (!checkPassword(user.getPwd()) || !checkEmail(user.getMail())){
            throw new DBException("Email or password is not valid");
        }
        if (checkDuplicate(user)){
            throw new duplicateException("User already exists");
        }
        DB.addData(new String[]{user.getMail(),user.getPwd(),user.getSex(),user.getChb()});

    }


    private static boolean checkDuplicate(User user){
        try{
            List<String[]> users = DB.getAllUsers();
            int i =0;
            while(i < users.size()) {
                if(user.getMail().equalsIgnoreCase(users.get(i)[0])){
                    return true;
                }
                i++;
            }
        }catch (DBException e){
            e.getMessage();
        }
        return false;
    }


    private static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^(\\w+([\\.-]?\\w+)*)@(\\w+([\\.-]?\\w+)*\\.\\w{2,4})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean checkPassword(String password){
        return !(password == null || password.length() < 4 || password.length() > 16);
    }

}
