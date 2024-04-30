select id, fish_name ,length
from fish_info a,  fish_name_info b
where a.fish_type = b.fish_type and (a.fish_type,length) in (select fish_type, max(length) from fish_info group by fish_type)
order by id asc