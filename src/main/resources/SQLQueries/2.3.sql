SELECT 
    city_id,
    City.name,
    country_id,
    Country.name,
    City.population AS population,
    continent
FROM
    City
        JOIN
    CityInCountry ON id = city_id
        JOIN
    Country ON country_id = Country.id
        AND capital = City.id
ORDER BY City.population DESC
LIMIT 1


