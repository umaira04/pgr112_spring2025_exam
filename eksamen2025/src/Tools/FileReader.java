package Tools;

import Artifacts.ElectricCar;
import Artifacts.FossilCar;
import Artifacts.Motorcycle;
import Artifacts.Scrapyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    //ARRAYLISTER FOR Å LAGRE DATA FRA FIL
    private ArrayList<Scrapyard> scrapyardList = new ArrayList<>();
    private ArrayList<ElectricCar> electricCarList = new ArrayList<>();
    private ArrayList<FossilCar> fossilCarList = new ArrayList<>();
    private ArrayList<Motorcycle> motorcycleList = new ArrayList<>();


    //LESER FRA FIL OG LAGRER INN I EN ARRAYLIST
    public void readFile() throws FileNotFoundException {
        File file = new File("src/files/vehicles.txt");
        try (Scanner reader = new Scanner(file)) {
            int numberOfScrapyards = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < numberOfScrapyards; i++) {
                int id = Integer.parseInt(reader.nextLine());
                String name = reader.nextLine();
                String address = reader.nextLine();
                String phoneNumber = reader.nextLine();
                scrapyardList.add(new Scrapyard(id, name, address, phoneNumber));
                reader.nextLine();//HOPPER OVER ---
            }
            int numberOfVehicles = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < numberOfVehicles; i++) {
                int vehicleId = Integer.parseInt(reader.nextLine());
                int scrapyardId = Integer.parseInt(reader.nextLine());
                String vehicleType = reader.nextLine();
                String brand = reader.nextLine();
                String model = reader.nextLine();
                int yearModel = Integer.parseInt(reader.nextLine());
                String registrationNumber = reader.nextLine();
                String chassisNumber = reader.nextLine();
                boolean driveable = Boolean.parseBoolean(reader.nextLine());
                int numberOfSellableWheels = Integer.parseInt(reader.nextLine());
                switch (vehicleType) {
                    case "FossilCar" -> {
                        String fuelType = reader.nextLine();
                        int fuelAmount = Integer.parseInt(reader.nextLine());
                        fossilCarList.add(new FossilCar(vehicleId, brand, model, yearModel, registrationNumber,
                                chassisNumber, driveable, numberOfSellableWheels, scrapyardId, fuelType, fuelAmount));
                    }
                    case "Motorcycle" -> {
                        boolean hasSidecar = Boolean.parseBoolean(reader.nextLine());
                        int engineCapacity = Integer.parseInt(reader.nextLine());
                        boolean isModified = Boolean.parseBoolean(reader.nextLine());
                        int numberOfWheels = Integer.parseInt(reader.nextLine());
                        motorcycleList.add(new Motorcycle(vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardId, hasSidecar, engineCapacity, isModified, numberOfWheels));
                    }
                    case "ElectricCar" -> {
                        int batteryCapacity = Integer.parseInt(reader.nextLine());
                        int chargeLevel = Integer.parseInt(reader.nextLine());
                        electricCarList.add(new ElectricCar(vehicleId, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardId, batteryCapacity, chargeLevel));
                    }
                }
                reader.nextLine();//HOPPER OVER ---
            }
        }
        //SJEKKER AT ALT ER LAGT INN I ARRAYLISTER
        //electricCarList.forEach(System.out::println);
        //fossilCarList.forEach(System.out::println);
        //motorcycleList.forEach(System.out::println);
        //scrapyardList.forEach(System.out::println);
    }


    //GETTERE TIL ARRAYLIST
    public ArrayList<Scrapyard> getScrapyardList() {
        return scrapyardList;
    }

    public ArrayList<ElectricCar> getElectricCarList() {
        return electricCarList;
    }

    public ArrayList<FossilCar> getFossilCarList() {
        return fossilCarList;
    }

    public ArrayList<Motorcycle> getMotorcycleList() {
        return motorcycleList;
    }
}
