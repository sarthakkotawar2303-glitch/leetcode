# Write your MySQL query statement below
select b.name
from Employee a
join Employee b on b.id=a.managerId
Group by b.id,b.name
having count(*)>=5;