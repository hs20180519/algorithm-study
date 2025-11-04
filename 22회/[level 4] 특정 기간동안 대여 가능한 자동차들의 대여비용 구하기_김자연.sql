select cc.car_id, cc.car_type, truncate(daily_fee*30*(1-discount_rate*0.01), 0) fee
from car_rental_company_car cc
left join car_rental_company_discount_plan dr on cc.car_type = dr.car_type
where duration_type like '30%'
and cc.car_type in ('세단', 'SUV')
and not exists (
    select 1
    from car_rental_company_rental_history rh
    where rh.car_id = cc.car_id
    and rh.start_date <= '2022-11-30'
    and rh.end_date   >= '2022-11-01'
)
having fee >= 500000 and fee < 2000000
order by fee desc, car_type, car_id desc;
