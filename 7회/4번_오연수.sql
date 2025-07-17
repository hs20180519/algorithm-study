SELECT hour(datetime) AS `HOUR`, count(*) AS `COUNT`
FROM ANIMAL_OUTS
WHERE time(datetime) >= '09:00' AND time(datetime) <= '19:59'
GROUP BY hour(datetime)
ORDER BY hour(datetime)
