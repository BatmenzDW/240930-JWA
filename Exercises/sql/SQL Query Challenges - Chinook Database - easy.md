# SQL Easy Challenges

## Objective
Provide new users of SQL with easy practice by looking over an ERD and creating SQL SELECT queries.

## Description
This activity involves a series of SQL challenges designed to help new users practice writing SELECT queries using the Chinook database. Participants will be given an ERD and tasked with creating queries that meet specific criteria.

## Main Goals
- Write SQL queries to retrieve specific data from the Chinook database.
- Practice using concatenation, ordering, filtering, and limiting results.
- Gain familiarity with common SQL query patterns and techniques.

## Requirements
- **Write Queries**: Create SQL SELECT queries that produce the desired results.
- **Use SQL Functions and Clauses**: Utilize functions like concatenation and clauses like ORDER BY, WHERE, and LIMIT.
- **Practice with Real Data**: Use the Chinook database to run and test queries.

## Instructions

### Setup
1. Ensure you have access to the Chinook database.
2. Open your preferred SQL query tool and connect to the Chinook database.

### DQL Queries
1. Write a query to concatenate the first and last names of employees in a column called "Name"
2. Write a query to concatenate and order employee names in descending order called "Name". The names should follow the given pattern: "Last, First"
3. Write a query to select the first name, last name, and city from the customer table. Order the data by the city names in alphabetical order
4. Write a query to select track names starting with the letter "A"
5. Write a query to select all cities from the customer table without including duplicate data
6. Write a query to select the five most expensive invoice totals
7. Write a query to select the 4th largest invoice total
8. Write a query to select the first and last names of customers from France
9. Write a query to select invoices created between March 29th 2012 and May 13th 2012

### DDL Queries
1. Write a query to create a table called "band_member" with a primary key column of type integer called "member_id" and a text column called "name"
2. Write a query to rename the "band_member" table to "BandMember"
3. write a query to rename the "member_id" column to "MemberId"
4. Write a query to rename the "name" column to "FirstName"
5. Write a query to add a column of type text to the table called "LastName"
6. Write a query to add a column of type integer called "ArtistId" to the table. This column should be a foreign key that points to the ArtistId column in the Artist table
