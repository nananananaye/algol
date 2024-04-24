-- 코드를 작성해주세요
select  year(DIFFERENTIATION_DATE) as YEAR,
   (maxsize-size_of_colony) as YEAR_DEV, ID
from ECOLI_DATA, (select date_format(DIFFERENTIATION_DATE,'%Y') as year, max(size_of_colony) as maxsize
                  from ecoli_data 
                  group by  date_format(DIFFERENTIATION_DATE,'%Y')) as B
where date_format(DIFFERENTIATION_DATE,'%Y') = B.year
order by year asc, year_dev asc;