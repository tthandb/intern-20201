import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        DatabaseController databaseController = new DatabaseController();
        try {
            databaseController.getMostCrowdedCityOfEachCountry();
            databaseController.getMostCrowdedCityOfEachContinent();
            databaseController.getMostCrowdedCapital();
            databaseController.getMostCrowdedCityOfEachContinent();
            databaseController.orderCountriesByNumberOfCities();
            databaseController.orderCountriesByPopulationDensity();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
