public class SQLQueries {
    public static final String sql21 = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        country_id, MAX(City.population) AS maxpop\n" +
            "    FROM\n" +
            "        City\n" +
            "    JOIN CityInCountry ON id = city_id\n" +
            "    JOIN Country ON country_id = Country.id\n" +
            "    GROUP BY country_id\n" +
            "    ) AS cte\n" +
            "        JOIN\n" +
            "    (SELECT \n" +
            "        city_id,\n" +
            "            City.name AS city_name,\n" +
            "            country_id,\n" +
            "            Country.name AS country_name,\n" +
            "            City.population AS population\n" +
            "    FROM\n" +
            "        City\n" +
            "    JOIN CityInCountry ON id = city_id\n" +
            "    JOIN Country ON country_id = Country.id) AS cte2 \n" +
            "\t\tON cte.country_id = cte2.country_id AND cte.maxpop = cte2.population\n";
    public static final String sql22 = "select * from (SELECT \n" +
            "        city_id,\n" +
            "            City.name AS city_name,\n" +
            "            country_id,\n" +
            "            City.population AS population,\n" +
            "            Country.continent as continent\n" +
            "           \n" +
            "    FROM\n" +
            "        City\n" +
            "    JOIN CityInCountry ON id = city_id\n" +
            "    JOIN Country ON country_id = Country.id) as cte1\n" +
            "  join\n" +
            "(SELECT \n" +
            "    Country.continent as continent, MAX(City.population) as maxpop\n" +
            "FROM\n" +
            "    City\n" +
            "        JOIN\n" +
            "    CityInCountry ON id = city_id\n" +
            "        JOIN\n" +
            "    Country ON country_id = Country.id\n" +
            "GROUP BY continent\n" +
            ") as cte2 on cte1.continent = cte2.continent and cte1.population = cte2.maxpop\n";
    public static final String sql23 = "SELECT \n" +
            "    city_id,\n" +
            "    City.name,\n" +
            "    country_id,\n" +
            "    Country.name,\n" +
            "    City.population AS population,\n" +
            "    continent\n" +
            "FROM\n" +
            "    City\n" +
            "        JOIN\n" +
            "    CityInCountry ON id = city_id\n" +
            "        JOIN\n" +
            "    Country ON country_id = Country.id\n" +
            "        AND capital = City.id\n" +
            "ORDER BY City.population DESC\n" +
            "LIMIT 1\n" +
            "\n";
    public static final String sql24 = "SELECT \n" +
            "    city_id,  city_name, country_id, country_name, population, cte1.continent as continent\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        max(City.population) AS maxpop, continent\n" +
            "    FROM\n" +
            "        City\n" +
            "    JOIN CityInCountry ON id = city_id\n" +
            "    JOIN Country ON country_id = Country.id\n" +
            "        AND capital = City.id\n" +
            "    GROUP BY continent) AS cte1\n" +
            "        JOIN\n" +
            "    (SELECT \n" +
            "        city_id,\n" +
            "    City.name as city_name,\n" +
            "    country_id,\n" +
            "Country.name as country_name,\n" +
            "    City.population AS population,\n" +
            "    continent\n" +
            "    FROM\n" +
            "        City\n" +
            "    JOIN CityInCountry ON id = city_id\n" +
            "    JOIN Country ON country_id = Country.id\n" +
            "        AND capital = City.id) as cte2\n" +
            "        on maxpop = cte2.population and cte1.continent= cte2.continent\n" +
            "\n" +
            "\n";
    public static final String sql25 = "   SELECT \n" +
            "    Country.name AS country_name,\n" +
            "    COUNT(*) AS number_of_cities\n" +
            "FROM\n" +
            "    City\n" +
            "        JOIN\n" +
            "    CityInCountry ON id = city_id\n" +
            "        JOIN\n" +
            "    Country ON country_id = Country.id\n" +
            "GROUP BY country_name\n" +
            "order by number_of_cities desc\n";
    public static final String sql26 = "SELECT \n" +
            "    *, (population / surface_area) AS population_density\n" +
            "FROM\n" +
            "    Country\n" +
            "WHERE\n" +
            "    (population > 0)\n" +
            "ORDER BY population_density DESC";
}
