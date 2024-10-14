select * from Employee e ;

/*
	we can use the results of a sub query (select statement wrapped in
	parenthesis) and its result set as a stand in for directly accessing
	table data. This is particularly useful when you need some data that
	has been transformed by a function to be used in your query
*/
select e.firstname, e.lastname, m.manager from Employee e
join 
	(
		select firstname || " " || lastname as "manager", 
		EmployeeId from employee
	) as m 
on e.ReportsTo = m.employeeid
order by manager asc;