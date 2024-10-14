-- example solution for customers assisted sql challenge

/*
	This coding challenge is a good place to use functions: functions
	in sql are repeatable operations that can transform the data in
	your result sets
*/

select 
	e.employeeid, 
	e.firstname, 
	e.lastname, 
	count(supportrepid) as "CustomersAssisted" 
from Employee e
join customer c on e.EmployeeId = c.SupportRepId 
group by EmployeeId
order by CustomersAssisted asc;

/*
	aggregate functions perform some type of transformation on a 
	collection of data and returns a single result from the operation
*/
select count(employeeid) from employee;

select * from employee;
select * from customer;





