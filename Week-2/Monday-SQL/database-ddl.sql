/*
	Typical Database Structure
	
	- database
		- schema
			- table
				- row/column structure
				- rows represent individual records/entries
				- columns represent individual bits of data in the record/entry
*/

/*
 * Structured Query Language (SQL) is a common syntax used to manipulate
 * databases. This includes actions like creating tables, editing those
 * tables, inserting records, updating records, etc.
 * 
 * There are 5 SQL sublanguages that facilitate database interactions
 */

-- Data Definition Language (DDL)
-- create is used to create resources like tables, indexes, views, etc
CREATE TABLE person(
	first_name text, 
	last_name text, 
	age int
);

-- you can add if not exists to prevent an error if trying to create a table that already exists
CREATE TABLE IF NOT EXISTS pet(
	pet_name text
);

-- drop is used to delete resources like tables, indexes, views, etc
DROP TABLE person; -- will cause an error if table does not exist
DROP TABLE IF EXISTS person; -- will not cause error if table does not exist

-- alter is used to edit an exisiting resource
ALTER TABLE individual RENAME to person;

ALTER TABLE person ADD COLUMN birthday text;

ALTER TABLE person ALTER COLUMN birthday TYPE varchar(20);-- not supported in SQLite

ALTER TABLE person ALTER COLUMN birthday RENAME to b_day;

ALTER TABLE person DROP COLUMN birthday;

-- in SQLite, if you want to alter a column, you must drop it and recreate it how you want


-- truncate is used to remove all records from a table
TRUNCATE TABLE person; -- in non-sqlite database



















