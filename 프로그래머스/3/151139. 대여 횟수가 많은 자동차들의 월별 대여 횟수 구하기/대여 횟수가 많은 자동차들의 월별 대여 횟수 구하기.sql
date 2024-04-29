select month(start_date) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(start_date,'%Y-%m') between '2022-08' and '2022-10' and car_id in (select car_id
                from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                where date_format(start_date,'%Y-%m') between '2022-08' and '2022-10'
                group by car_id having count(*)>=5) 
group by month(start_date), car_id  having records is not null
order by month(start_date) asc,car_id desc;