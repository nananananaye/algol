-- 코드를 입력하세요
SELECT f.product_id, product_name, sum(amount)*price as total_sales
from food_product p, food_order  f
where p.product_id = f.product_id and  produce_date like '2022-05-%'
group by f.product_id
order by total_sales desc , f.product_id asc;