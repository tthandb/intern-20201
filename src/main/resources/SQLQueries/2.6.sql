SELECT 
    *, (population / surface_area) AS population_density
FROM
    Country
WHERE
    (population > 0)
ORDER BY population_density DESC