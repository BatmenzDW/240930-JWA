/*
	Anytime you are interacting with the actual data stored in your
	tables you are performing some form of Data Manipulation Langauge
	(DML) or Data Query Language (DQL).
*/

-- DML invovles inserting data, updating data, and deleting data
/*
	if you want to add records to a table (add rows) you use the insert
	keyword. Unless you specify otherwise, you need to provide data
	for all columns in a table. That being said, you can provide only
	partial detail, but you must tell the database what columns you
	are providing data for. Also, if you know you are adding multiple
	records as part of a transaction, you can separate those different
	records via a comma
*/

-- all data provided
insert into person values ('Sally', 'Sallington', 32);

-- partial data provided
insert into person (first_name, last_name) 
values ('Slagathor', 'the Great');

-- multiple records provided
insert into person values
('Billy', 'Billington', 43),
('Sarah', 'Sarrington', 50);

/*
	If you want to edit data that already exists in your table you use
	the update keyword. If you don't specify which record/s you want
	affected by the update statement then every record will be changed
	by an update. Typically, you would use the "where" keyword to target
	one or more rows to be update
*/

-- every record will have its age set to this value
update person set age = 1000000;

update person set age = 30 where first_name = 'Ted';
update person set age = 32 where first_name = 'Sally';
update person set age = 43 where first_name = 'Billy';
update person set age = 50 where first_name = 'Sarah';

-- you can change multiple columns
update person set 
	first_name = 'Chad', 
	last_name = 'Chaddington', 
	age = 23 
-- keep in mind all records that match your where statement will be updated
where first_name = 'Slagathor';

/*
	Anytime you need to remove records from a database you use the delete
	keyword. Similar to your update, be careful with this, because unless
	you use TCL and give yourself a rollback point, you can't undo your
	deletes
*/

-- this will delete all records from the person table
delete from person;

delete from person where first_name = 'Chad';

/*
	To retrieve information from your tables you use the "select" keyword.
	This action is far more complex than the other DML statements in the
	ways youcan implement it, but for DML purposes, all we need to know
	is they "Select" keyword indicates we want to retrieve information 
	from the database
*/

-- select * returns all records  with all column data from the specified table
select * from person;

-- this returns all column info of records that have an age of 43
select * from person where age = 43;

-- this returns just the first and last name columns
select first_name, last_name from person where age = 43;

select * from person where age < 40 and age > 29;

-- this returns all records that hava an "l" in the first name
select * from person where first_name like '%l%';



/*
	The queries listed here are the basic tools available to you to
	facilitate your CRUD operations:
	- Create (insert)
	- Read (select)
	- Update (upate)
	- Delete (delete
*/





