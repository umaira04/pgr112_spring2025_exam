package Tools;

import java.sql.Connection;
import java.sql.SQLException;

public class SendToDB {
    private DBProvider dbProvider = new DBProvider();

    //SENDER INFORMASJON LEST FRA FIL TIL DBPROVIDER OG LEGGER INN ROLLBACK
    public void writeToDB(FileReader fileReader) throws SQLException {
        try (Connection con = dbProvider.getExamDS().getConnection()) {
            boolean autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            try {
                dbProvider.writeScrapyard(fileReader.getScrapyardList(), con);
                dbProvider.writeElectricCar(fileReader.getElectricCarList(), con);
                dbProvider.writeFossilCar(fileReader.getFossilCarList(), con);
                dbProvider.writeMotorcycle(fileReader.getMotorcycleList(), con);
            } catch (SQLException e) {
                con.rollback();
                System.out.println(e.getMessage());
                System.out.println("ROLLED BACK. DATA NOT ADDED TO DB");

            } finally {
                con.setAutoCommit(autoCommit);
            }
        }
    }


}
