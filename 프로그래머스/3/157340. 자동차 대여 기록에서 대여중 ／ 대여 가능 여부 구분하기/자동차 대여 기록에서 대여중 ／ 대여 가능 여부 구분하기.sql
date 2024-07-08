-- 코드를 입력하세요
SELECT car_id, case when sum(case when  start_date <= date_format('2022-10-16','%Y-%m-%d') and date_format('2022-10-16','%Y-%m-%d') <= end_date then 1 else 0 end)=0 then '대여 가능' else '대여중'  end as 'Availability'
from car_rental_company_rental_history
group by car_id
order by car_id desc

 