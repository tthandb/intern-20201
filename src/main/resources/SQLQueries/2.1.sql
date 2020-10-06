SELECT 
    *
FROM
    (SELECT 
        country_id, MAX(City.population) AS maxpop
    FROM
        City
    JOIN CityInCountry ON id = city_id
    JOIN Country ON country_id = Country.id
    GROUP BY country_id
    ) AS cte
        JOIN
    (SELECT 
        city_id,
            City.name AS city_name,
            country_id,
            Country.name AS country_name,
            City.population AS population
    FROM
        City
    JOIN CityInCountry ON id = city_id
    JOIN Country ON country_id = Country.id) AS cte2 
		ON cte.country_id = cte2.country_id AND cte.maxpop = cte2.population

