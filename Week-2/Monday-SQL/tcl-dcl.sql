/*
	Transaction Control Language (TCL) is used to control when data
	persistence happens in SQL. A Transaction is any query that tries
	to make a change to your tables: by using TCL you can wrap multiple
	transactional commands inside a single "transaction": this makes
	it so that all of the transactional commands either succeed together
	or fail together
*/

insert into person values(1, 'Billy', 'Billington', 73);
insert into person values(2, 'Sally', 'Sallington', 45);

/* 
 * this tells the database we are starting a single transaction: all
 * queries between the BEGIN and END (or COMMIT) statements need to
 * succeed or fail together
 */
BEGIN;
	insert into person values(6, 'Vick', 'Vickington', 6);
	insert into person values(5, 'Patty', 'Pattington', 16);
	insert into person values(8, 'Slagathor', 'The Great', 1000000);
commit;

begin;
	insert into person values(6, 'Vick', 'Vickington', 6);
	-- savepoint creates a rollback position
	savepoint my_savepoint;

	insert into person values(7, 'Patty', 'Pattington', 16);
	-- rollback lets you undo queries after the given savepoint
	rollback to my_savepoint;

	insert into person values(8, 'Slagathor', 'The Great', 1000000);
	-- releases the savepoint from memory
	release savepoint my_savepoint;
end;

-- Data Control Language (DCL) is used to create and manage roles in a database
-- roles are what determine the actions (queries to be executed) users can take in your database

create role customer;

-- we can give the role specific permissions on specific tables
GRANT INSERT, SELECT, UPDATE ON TABLE public.person TO customer;

-- permissions can also be revoked
REVOKE INSERT, SELECT, UPDATE ON TABLE public.person FROM customer;

-- super users can be created with a grant all command
grant all privileges on table public.person; 




