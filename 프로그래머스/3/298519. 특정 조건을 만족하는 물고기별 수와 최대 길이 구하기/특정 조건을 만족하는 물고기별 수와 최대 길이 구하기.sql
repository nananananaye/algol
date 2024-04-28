-- 코드를 작성해주세요

select count(*) as fish_count, max(length) as max_length, fish_type
from fish_info
group by fish_type  having (sum(ifnull(length,10))/count(*))>=33
order by fish_type asc;