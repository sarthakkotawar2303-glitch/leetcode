# Write your MySQL query statement below
select * from Cinema
where description!='boring' AND id%2!=0
Order by rating DESC;