select fo.product_id, product_name, sum(amount*price) total_sales
from food_order fo join food_product fp on fo.product_id = fp.product_id
where year(produce_date) = 2022 and month(produce_date) = 5
group by fo.product_id
order by total_sales desc, fo.product_id
