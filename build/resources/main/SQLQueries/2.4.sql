SELECT
    city_id,  city_name, country_id, country_name, population, cte1.continent as continent
FROM
    (SELECT
        max(City.population) AS maxpop, continent
    FROM
        City
    JOIN CityInCountry ON id = city_id
    JOIN Country ON country_id = Country.id
        AND capital = City.id
    GROUP BY continent) AS cte1
        JOIN
    (SELECT
        city_id,
    City.name as city_name,
    country_id,
Country.name as country_name,
    City.population AS population,
    continent
    FROM
        City
    JOIN CityInCountry ON id = city_id
    JOIN Country ON country_id = Country.id
        AND capital = City.id) as cte2
        on maxpop = cte2.population and cte1.continent= cte2.continent


