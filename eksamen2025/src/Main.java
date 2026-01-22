import Tools.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {


        //IMPORTERER DATA FRA FIL OG SENDER TIL DATABASE
        FileReader fileReader = new FileReader();
        try{
            fileReader.readFile();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //SENDER DATA HENTET FRA FILEREADER TIL SQL OG BRUKER FILEREADER SINE GETARRAYS FOR Å SENDE TIL DB
        try {
            new SendToDB().writeToDB(fileReader);
        } catch (SQLException e) {
            System.out.println("error while writing to db" + e.getMessage());
            e.printStackTrace();
        }

        //KJØRER PROGRAMMET SOM GIR BRUKEREN MULIGHET TIL Å UTFØRE SQL SPØRRINGER MOT DATABASEN
        try{
            new Program().run();
        } catch (SQLException e) {
            System.out.println("error while running program" + e.getMessage());
            e.printStackTrace();
        }
    }
}
