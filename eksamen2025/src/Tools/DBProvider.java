package Tools;
import Artifacts.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import java.util.ArrayList;

public class DBProvider implements SQLStatements {

    private MysqlDataSource examDS;

    public MysqlDataSource getExamDS() {
        return examDS;
    }

    //OPPKOBLING MOT DB
    public DBProvider() {
        examDS = new MysqlDataSource();
        examDS.setServerName(PropertiesProvider.PROPS.getProperty("host"));
        examDS.setPort(Integer.parseInt(PropertiesProvider.PROPS.getProperty("port")));
        examDS.setDatabaseName(PropertiesProvider.PROPS.getProperty("db_name"));
        examDS.setUser(PropertiesProvider.PROPS.getProperty("uname"));
        examDS.setPassword(PropertiesProvider.PROPS.getProperty("password"));
    }


    //          ADD METODER
    public void writeScrapyard(ArrayList<Scrapyard> scrapyardList, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(ADD_SCRAPYARD_SQL)) {
            for (Scrapyard scrapyard : scrapyardList) {
                statement.setInt(1, scrapyard.getId());
                statement.setString(2, scrapyard.getName());
                statement.setString(3, scrapyard.getAdress());
                statement.setString(4, scrapyard.getPhoneNumber());
                statement.executeUpdate();
            }
        }

    }

    public void writeElectricCar(ArrayList<ElectricCar> electricCarList, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(ADD_ELECTRIC_SQL)) {
            for (ElectricCar x : electricCarList) {
                statement.setInt(1, x.getVehicleID());
                statement.setString(2, x.getBrand());
                statement.setString(3, x.getModel());
                statement.setInt(4, x.getYearModel());
                statement.setString(5, x.getRegistrationNumber());
                statement.setString(6, x.getChassisNumber());
                statement.setBoolean(7, x.isDriveable());
                statement.setInt(8, x.getNumberOfSellableWheels());
                statement.setInt(9, x.getScrapyardID());
                statement.setInt(10, x.getBatteryCapacity());
                statement.setInt(11, x.getChargeLevel());
                statement.executeUpdate();
            }
        }
    }

    public void writeFossilCar(ArrayList<FossilCar> fossilCarList, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(ADD_FOSSIL_SQL)) {
            for (FossilCar x : fossilCarList) {
                statement.setInt(1, x.getVehicleID());
                statement.setString(2, x.getBrand());
                statement.setString(3, x.getModel());
                statement.setInt(4, x.getYearModel());
                statement.setString(5, x.getRegistrationNumber());
                statement.setString(6, x.getChassisNumber());
                statement.setBoolean(7, x.isDriveable());
                statement.setInt(8, x.getNumberOfSellableWheels());
                statement.setInt(9, x.getScrapyardID());
                statement.setString(10, x.getFuelType());
                statement.setInt(11, x.getFuelAmount());
                statement.executeUpdate();
            }
        }
    }

    public void writeMotorcycle(ArrayList<Motorcycle> motorcycleList, Connection con) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement(ADD_MOTORCYCLE_SQL)) {
            for (Motorcycle x : motorcycleList) {
                statement.setInt(1, x.getVehicleID());
                statement.setString(2, x.getBrand());
                statement.setString(3, x.getModel());
                statement.setInt(4, x.getYearModel());
                statement.setString(5, x.getRegistrationNumber());
                statement.setString(6, x.getChassisNumber());
                statement.setBoolean(7, x.isDriveable());
                statement.setInt(8, x.getNumberOfSellableWheels());
                statement.setInt(9, x.getScrapyardID());
                statement.setBoolean(10, x.isHasSidecar());
                statement.setInt(11, x.getEngineCapacity());
                statement.setBoolean(12, x.isModified());
                statement.setInt(13, x.getNumberOfWheels());
                statement.executeUpdate();
            }
        }
    }


    //          GET METODER
    public ArrayList<Motorcycle> printMotorcycles() throws SQLException {
        return getMotorcycle(GET_MOTORCYCLE_SQL);
    }

    public ArrayList<Motorcycle> printDriveableMotorcycles() throws SQLException {
        return getMotorcycle(GET_DRIVABLE_MOTORCYCLE);
    }

    private ArrayList<Motorcycle> getMotorcycle(String motorcycleSQL) throws SQLException {
        ArrayList<Motorcycle> motorcycleList = new ArrayList<>();
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(motorcycleSQL)
        ) {
            while (rs.next()) {
                int vehicleId = rs.getInt("vehicleId");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int yearModel = rs.getInt("yearModel");
                String registrationNumber = rs.getString("registrationNumber");
                String chassisNumber = rs.getString("chassisNumber");
                boolean driveable = rs.getBoolean("driveable");
                int numberOfSellableWheels = rs.getInt("numberOfSellableWheels");
                int scrapyardId = rs.getInt("scrapyardId");
                boolean hasSidecar = rs.getBoolean("hasSidecar");
                int engineCapacity = rs.getInt("engineCapacity");
                boolean isModified = rs.getBoolean("isModified");
                int numberOfWheels = rs.getInt("numberOfWheels");
                Motorcycle m = new Motorcycle(vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardId, hasSidecar, engineCapacity, isModified, numberOfWheels);
                motorcycleList.add(m);
            }
            return motorcycleList;
        }
    }

    public ArrayList<ElectricCar> printElectricCars() throws SQLException {
        return getElectricCars(GET_ELECTRIC_SQL);
    }

    public ArrayList<ElectricCar> printDriveableElectric() throws SQLException {
        return getElectricCars(GET_DRIVABLE_ELECTRIC);
    }

    private ArrayList<ElectricCar> getElectricCars(String electricSQL) throws SQLException {
        ArrayList<ElectricCar> electricCarList = new ArrayList<>();
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(electricSQL)
        ) {
            while (rs.next()) {
                int vehicleId = rs.getInt("vehicleId");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int yearModel = rs.getInt("yearModel");
                String registrationNumber = rs.getString("registrationNumber");
                String chassisNumber = rs.getString("chassisNumber");
                boolean driveable = rs.getBoolean("driveable");
                int numberOfSellableWheels = rs.getInt("numberOfSellableWheels");
                int scrapyardId = rs.getInt("scrapyardId");
                int batteryCapacity = rs.getInt("batteryCapacity");
                int chargeLevel = rs.getInt("chargeLevel");
                ElectricCar m = new ElectricCar(vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardId, batteryCapacity, chargeLevel);
                electricCarList.add(m);
            }
            return electricCarList;
        }
    }

    public ArrayList<FossilCar> printFossilCars() throws SQLException {
        return getFossilCars(GET_FOSSIL_SQL);
    }

    public ArrayList<FossilCar> printDriveableFossil() throws SQLException {
        return getFossilCars(GET_DRIVABLE_FOSSIL);
    }

    private ArrayList<FossilCar> getFossilCars(String fossilSQL) throws SQLException {
        ArrayList<FossilCar> fossilCarList = new ArrayList<>();
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(fossilSQL)
        ) {
            while (rs.next()) {
                int vehicleId = rs.getInt("vehicleId");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int yearModel = rs.getInt("yearModel");
                String registrationNumber = rs.getString("registrationNumber");
                String chassisNumber = rs.getString("chassisNumber");
                boolean driveable = rs.getBoolean("driveable");
                int numberOfSellableWheels = rs.getInt("numberOfSellableWheels");
                int scrapyardId = rs.getInt("scrapyardId");
                String fuelType = rs.getString("fuelType");
                int fuelAmount = rs.getInt("fuelAmount");
                FossilCar f = new FossilCar(vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardId, fuelType, fuelAmount);
                fossilCarList.add(f);
            }
            return fossilCarList;
        }
    }


    public int getFuelAmount() throws SQLException {
        int fuelAmount = 0;
        try (Connection conn = examDS.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(GET_TOTAL_FUELAMOUT)
        ) {
            while (rs.next()) {
                fuelAmount = rs.getInt("fuelAmount");
            }
            return fuelAmount;
        }
    }


}

