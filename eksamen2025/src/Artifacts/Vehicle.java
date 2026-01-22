package Artifacts;

public abstract class Vehicle {
    private int vehicleId;
    private String brand;
    private String model;
    private int yearModel;
    private String registrationNumber;
    private String chassisNumber;
    private boolean driveable;
    private int numberOfSellableWheels;
    private int scrapyardID;


    public Vehicle(int vehicleID, String brand, String model, int yearModel, String registrationNumber,
                   String chassisNumber, boolean driveable, int numberOfSellableWheels, int scrapyardID) {
        this.vehicleId = vehicleID;
        this.brand = brand;
        this.model = model;
        this.yearModel = yearModel;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.driveable = driveable;
        this.numberOfSellableWheels = numberOfSellableWheels;
        this.scrapyardID = scrapyardID;
    }


    public int getVehicleID() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public boolean isDriveable() {
        return driveable;
    }

    public int getNumberOfSellableWheels() {
        return numberOfSellableWheels;
    }

    public int getScrapyardID() {
        return scrapyardID;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearModel=" + yearModel +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", driveable=" + driveable +
                ", numberOfSellableWheels=" + numberOfSellableWheels +
                ", scrapyardID=" + scrapyardID +
                '}';
    }
}
