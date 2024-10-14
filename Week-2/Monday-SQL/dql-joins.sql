select * from artist;

select * from album;
/*
	If you ever want to display data from multiple tables together in
	a single result set you can do so by utilizing join statements
	
	join statements will allow you to make a select request for data
	from multiple tables, and then facilitate how that data is returned
	in the result set
*/


/*
	if you just say "join" it defaults to an inner join: this matches
	records in the result set on whatever your "on" statement is only
	if there is a match
*/
select * from artist 
join album on artist.ArtistId = album.ArtistId
order by artist.ArtistId ;

-- natural join will perform a similar action without needing to specify the "on" condition
select * from Artist
natural join album;

/*
	left join will return all records from the "left" table and 
	matching records from the "right" table. If there are no matching
	records then null values are provided
*/

select firstname, lastname, name from customer 
left join artist on customer.CustomerId = artist.ArtistId
order by customer.CustomerId ;

/*
	right join will return all records from the "right" table and 
	matching records from the "left" table. If there is no matching 
	records then null values are provided

*/
select firstname, lastname, name from customer 
right join artist on customer.CustomerId = artist.ArtistId
order by customer.CustomerId ;


/*
	similar to left/right joins, full outer will return all records
	from both tables and join any records that match, if there is no
	match then null values will be provided instead
*/
select firstname, lastname, name from customer 
full outer join artist on customer.CustomerId = artist.ArtistId
order by customer.CustomerId ;


/*
	Set operations take column data from differing tables and combine
	them into a single column. You can either use a "union" operation or
	an "intersect" operation
*/


-- select column AS "column_name" sets an alias for the column
-- you can also make aliases for your tables
SELECT firstname AS "column_a", lastname AS "column_b" FROM Customer c
UNION -- combines results, removes duplicate DATA (all records that share all column data)
SELECT firstname, lastname FROM Employee
ORDER BY firstname asc;

--adding a duplicate record
INSERT INTO customer (firstname, lastname, email) 
VALUES ('Andrew', 'Adams', 'email@email.com');

-- adding a partial duplicate
INSERT INTO customer (firstname, lastname, email) 
VALUES ('Billy', 'Edwards', 'email1@email.com');



SELECT firstname AS "column_a", lastname AS "column_b" FROM Customer c
UNION all -- combines results, keeps duplicate data
SELECT firstname, lastname FROM Employee
ORDER BY firstname asc;

-- intersect will only return duplicate records (all columns match) between select statements
SELECT firstname AS "column_a", lastname AS "column_b" FROM Customer c
intersect
SELECT firstname, lastname FROM Employee
ORDER BY firstname asc;


/*
	If you ever want to exclude values from your initial select
	you can use the except operator to exclude values that are shared
	in the second select statement
*/
SELECT firstname AS "column_a", lastname AS "column_b" FROM Customer c
except
SELECT firstname, lastname FROM Employee
ORDER BY firstname asc;









