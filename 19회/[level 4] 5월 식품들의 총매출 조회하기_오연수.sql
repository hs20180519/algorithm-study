SELECT p.PRODUCT_ID, p.PRODUCT_NAME, sum(o.amount) * p.price AS TOTAL_SALES
FROM food_product p
JOIN food_order o ON p.product_id = o.product_id
WHERE o.produce_date BETWEEN '2022-05-01 00:00:00' AND '2022-05-31 23:59:59'
GROUP BY product_id, product_name
ORDER BY total_sales DESC, product_id ASC;
