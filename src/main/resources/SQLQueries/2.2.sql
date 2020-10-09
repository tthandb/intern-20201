select * from (SELECT 
        city_id,
            City.name AS city_name,
            country_id,
            City.population AS population,
            Country.continent as continent
           
    FROM
        City
    JOIN CityInCountry ON id = city_id
    JOIN Country ON country_id = Country.id) as cte1
  join
(SELECT 
    Country.continent as continent, MAX(City.population) as maxpop
FROM
    City
        JOIN
    CityInCountry ON id = city_id
        JOIN
    Country ON country_id = Country.id
GROUP BY continent
) as cte2 on cte1.continent = cte2.continent and cte1.population = cte2.maxpop

