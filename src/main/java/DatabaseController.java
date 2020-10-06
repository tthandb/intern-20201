import java.sql.*;

public class DatabaseController {
    String dbURL = "jdbc:mysql://localhost:3306/SampleDB";
    String username = "root";
    String password = "123456";
    Connection connection;

    DatabaseController() {
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("DB Connected");
            }
        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getRecords(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public void getMostCrowdedCityOfEachCountry() throws SQLException {
        ResultSet resultSet = getRecords(SQLQueries.sql21);
        while (resultSet.next()) {
            String cityId = resultSet.getString("city_id");
            String cityName = resultSet.getString("city_name");
            String countryId = resultSet.getString("country_id");
            String countryName = resultSet.getString("country_name");
            String population = resultSet.getString("population");
            String output = "%s - %s - %s - %s- %s";
            System.out.println(String.format(output, cityId, cityName, countryId, countryName, population));
        }
    }

    public void getMostCrowdedCityOfEachContinent() throws SQLException {
        ResultSet resultSet = getRecords(SQLQueries.sql22);
        while (resultSet.next()) {
            String cityId = resultSet.getString("city_id");
            String cityName = resultSet.getString("city_name");
            String continent = resultSet.getString("continent");
            String population = resultSet.getString("population");
            String output = "%s - %s - %s- %s";
            System.out.println(String.format(output, cityId, cityName, continent, population));
        }
    }

    public void getMostCrowdedCapital() throws SQLException {
        ResultSet resultSet = getRecords(SQLQueries.sql23);
        while (resultSet.next()) {
            String cityId = resultSet.getString("city_id");
            String cityName = resultSet.getString("city_name");
            String countryId = resultSet.getString("country_id");
            String countryName = resultSet.getString("country_name");
            String population = resultSet.getString("population");
            String output = "%s - %s - %s - %s- %s";
            System.out.println(String.format(output, cityId, cityName, countryId, countryName, population));
        }
    }

    public void getMostCrowdedCapitalOfEachContinent() throws SQLException {
        ResultSet resultSet = getRecords(SQLQueries.sql24);
        while (resultSet.next()) {
            String cityId = resultSet.getString("city_id");
            String cityName = resultSet.getString("city_name");
            String countryId = resultSet.getString("country_id");
            String countryName = resultSet.getString("country_name");
            String continent = resultSet.getString("continent");
            String population = resultSet.getString("population");
            String output = "%s - %s - %s - %s- %s - %s";
            System.out.println(String.format(output, cityId, cityName, countryId, countryName, continent, population));
        }
    }

    public void orderCountriesByNumberOfCities() throws SQLException {
        ResultSet resultSet = getRecords(SQLQueries.sql25);
        while (resultSet.next()) {
            String countryName = resultSet.getString("country_name");
            String numberOfCities = resultSet.getString("number_of_cities");
            String output = "%s - %s";
            System.out.println(String.format(output, countryName, numberOfCities));
        }
    }

    public void orderCountriesByPopulationDensity() throws SQLException {
        ResultSet resultSet = getRecords(SQLQueries.sql26);
        while (resultSet.next()) {
            String countryId = resultSet.getString("id");
            String countryName = resultSet.getString("name");
            String surfaceArea = resultSet.getString("surface_area");
            String population = resultSet.getString("population");
            String populationDensity = resultSet.getString("population_density");
            String output = "%s - %s - %s - %s - %s";
            System.out.println(String.format(output, countryId, countryName, surfaceArea, population, populationDensity));
        }
    }

}
