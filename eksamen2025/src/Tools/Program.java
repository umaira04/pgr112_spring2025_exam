package Tools;

import Artifacts.ElectricCar;
import Artifacts.FossilCar;
import Artifacts.Motorcycle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    DBProvider db = new DBProvider();

    //KJØRER PROGRAM SOM TAR IMOT BRUKERINPUT
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Pick an option");
            System.out.println("1. Se informasjon om alle kjøretøy");
            System.out.println("2. Se hvor mye drivstoff det er i alle fossile biler");
            System.out.println("3. Se informasjon om alle kjørbare kjøretøy");
            System.out.println("4. Se alle kjøretøy filtrert etter bilopphuggeri");
            System.out.println("5. Avslutt program");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> printFossilFuel();
                case 3 -> printDriveable();
                case 4 -> filterByScrapyard(scanner);
                case 5 -> System.out.println("Program finished. Bye");
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void filterByScrapyard(Scanner scanner) throws SQLException {
        System.out.println("Hvilken bilopphugger vil vil du se kjøretøy fra?");
        System.out.println("1. Oslo scrapyard");
        System.out.println("2. Bergen scrapyard");
        System.out.println("3. Trondheim scrapyard");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> printByScrapyard(1);
            case 2 -> printByScrapyard(2);
            case 3 ->printByScrapyard(3);
        }
    }

    private void printByScrapyard(int scrapyard) throws SQLException {
        ArrayList<Motorcycle> mc = db.printMotorcycles();
        ArrayList<FossilCar> fc = db.printFossilCars();
        ArrayList<ElectricCar> ec = db.printElectricCars();
        //HER HAR JEG VALGT Å BRUKE LAMDA UTRYKK FOR Å FILTERE ETTER SCRAPYARD
        //Kan også gjøres med sql spørring der du sender med scrapyard id som parameter inn i SQL spørring,
        //men valgte å ikke gjøre det for å vise bruk av lambda uttrykk
        mc.stream().filter(s -> s.getScrapyardID() == scrapyard).forEach(System.out::println);
        fc.stream().filter(s -> s.getScrapyardID() == scrapyard).forEach(System.out::println);
        ec.stream().filter(s -> s.getScrapyardID() == scrapyard).forEach(System.out::println);
    }

    private void printDriveable() throws SQLException {
        System.out.println("Printing all driveable vehicles");
        ArrayList<Motorcycle> m = db.printDriveableMotorcycles();
        ArrayList<ElectricCar> e = db.printDriveableElectric();
        ArrayList<FossilCar> f = db.printDriveableFossil();
        m.forEach(System.out::println);
        e.forEach(System.out::println);
        f.forEach(System.out::println);
        System.out.printf("Det er %d kjørbare fossilbiler\n", f.size());
        System.out.printf("Det er %d kjørbare elektriske biler\n", e.size());
        System.out.printf("Det er %d kjørbare motorsykler\n", m.size());
        System.out.printf("Det er totalt %d kjørbare kjøretøy\n", (f.size() + e.size() + f.size()));
    }

    private void printFossilFuel() throws SQLException {
        int fuelAmount = db.getFuelAmount();
        System.out.printf("Alle fossilbilene har totalt sett %d liter med drivstoff \n", fuelAmount);
    }

    public void printAllVehicles() throws SQLException {
        System.out.println("Printing all vehicles");
        ArrayList<Motorcycle> m = db.printMotorcycles();
        ArrayList<ElectricCar> e = db.printElectricCars();
        ArrayList<FossilCar> f = db.printFossilCars();
        m.forEach(System.out::println);
        e.forEach(System.out::println);
        f.forEach(System.out::println);
        System.out.printf("Det er %d fossilbiler\n", f.size());
        System.out.printf("Det er %d elektriske biler\n", e.size());
        System.out.printf("Det er %d motorsykler\n", m.size());
        System.out.printf("Det er totalt %d kjøretøy\n", (f.size() + e.size() + f.size()));
    }
}

