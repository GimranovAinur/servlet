package info.kpfu.ru.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import info.kpfu.ru.exceptions.DBException;


public class DB {

    public static final File FILE = new File("/home/asus2/file.csv");

    public static void addData(String[] data) throws DBException {
        try(CSVWriter writer = new CSVWriter(new FileWriter(FILE,true))){
            writer.writeNext(data);
            writer.close();
        }catch(IOException e){
            throw new DBException();
        }
    }

    public static List<String[]> getAllUsers() throws DBException {
        try{
            CSVReader reader = new CSVReader(new FileReader(FILE));
            return reader.readAll();
        }catch(IOException e){
            throw  new DBException();
        }
    }
}
