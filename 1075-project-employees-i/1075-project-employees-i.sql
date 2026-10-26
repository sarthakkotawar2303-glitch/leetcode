# Write your MySQL query statement below
select Project.project_id,round(AVG(Employee.experience_years),2) as average_years 
from Project
Inner join Employee on Employee.employee_id=Project.employee_id 
Group by Project.project_id;