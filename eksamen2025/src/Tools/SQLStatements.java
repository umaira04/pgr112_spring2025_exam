package Tools;

public interface SQLStatements {

    //ADD TO DATABASE
    String ADD_SCRAPYARD_SQL = "INSERT INTO scrapyard(scrapyardID, name, address, phoneNumber) VALUES (?, ?, ?, ?)";
    String ADD_ELECTRIC_SQL = "INSERT INTO electricCar (vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, batteryCapacity, chargeLevel) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    String ADD_FOSSIL_SQL = "INSERT INTO fossilCar (vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, fuelType, fuelAmount ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    String ADD_MOTORCYCLE_SQL = "INSERT INTO motorcycle (vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, hasSidecar, engineCapacity, isModified, numberOfWheels ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    //GET FROM DB
    String GET_ELECTRIC_SQL = "SELECT * FROM electricCar";
    String GET_FOSSIL_SQL = "SELECT * FROM fossilCar";
    String GET_MOTORCYCLE_SQL = "SELECT * FROM motorcycle";

    String GET_TOTAL_FUELAMOUT = "SELECT SUM(fuelAmount) AS fuelAmount FROM fossilCar;";

    //GET FROM DB WHERE DRIVABLE IS TRUE
    String GET_DRIVABLE_ELECTRIC = "SELECT * FROM electricCar WHERE driveable = TRUE ";
    String GET_DRIVABLE_FOSSIL = "SELECT * FROM fossilCar WHERE driveable = TRUE ";
    String GET_DRIVABLE_MOTORCYCLE = "SELECT * FROM motorcycle WHERE driveable = TRUE ";


}
