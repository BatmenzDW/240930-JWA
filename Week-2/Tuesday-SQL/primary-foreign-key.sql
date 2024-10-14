/*
	When creating tables it is common to add "constraints" to the columns.
	This allows you to enforce different rules, such as character limits,
	numeric sizes, whether duplicates are allowed, etc.
	
	Primary Key is a particulary important constraint because it is
	used as the identifier column for records in the table. It does
	the following specifics for the table:
	- adds the unique constraint to a column
	- typically adds the not null constraint to a column
*/

DROP TABLE pet;

-- for sqlite, if you want the database to be able to auto set values
-- set the column type as integer
-- in sqlite, to be safe, make your primary key not null explicitly
-- also definetly mark your foreign keys as not null
CREATE TABLE pet(
	collar integer PRIMARY KEY NOT null,
	species text,
	pet_name text,
	owner_id integer REFERENCES owner(owner_id) NOT null
);

-- if the integer type is set (or your database specific for auto increment)
-- you can leave off providing a value for the primary key and it will be
-- set for you
INSERT INTO pet (species, pet_name, owner_id) values('dog', 'Fluffy', 1);
INSERT INTO pet (species, pet_name, owner_id) VALUES ('cat', 'destroyer of doors', 2);



CREATE TABLE owner(
	owner_id integer PRIMARY KEY NOT NULL,
	owner_name text
);

INSERT INTO owner (owner_name) VALUES ('Teddy'), ('Sally');











