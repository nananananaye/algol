-- 코드를 작성해주세요
select quarter, count(*) as ecoli_count
from (select id, differentiation_date, case when month(differentiation_date) in (01,02,03) then '1Q'
                                      when month(differentiation_date) in (04,05,06) then '2Q'
                                      when month(differentiation_date) in (07,08,09) then '3Q'
                                      else '4Q' end as quarter
    from ecoli_data) a
group  by quarter
order by quarter
                                    