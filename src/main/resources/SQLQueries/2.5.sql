   SELECT 
    Country.name AS country_name,
    COUNT(*) AS number_of_cities
FROM
    City
        JOIN
    CityInCountry ON id = city_id
        JOIN
    Country ON country_id = Country.id
GROUP BY country_name
order by number_of_cities desc
