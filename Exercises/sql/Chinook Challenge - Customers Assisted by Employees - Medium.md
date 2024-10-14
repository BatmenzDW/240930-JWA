# Coding Challenge: Customers Assisted by Employees

## Challenge

The Chinook Music Company wants to analyze the performance of their support representatives. They are interested in knowing how many customers each employee has assisted. Your task is to write an SQL query to retrieve this information.

Create a query that returns the `EmployeeId`, `FirstName`, `LastName`, and the number of customers each employee has assisted in a column labeled `CustomersAssisted`. The results should be sorted by the number of customers assisted in ascending order.

You can assume the following table structures:![Chinook Database](Chinook-Database-ERD.png)

## Example
Given the tables and data in the Chinook database, the expected output of the query should look like:

| EmployeeId | FirstName | LastName | CustomersAssisted |
|------------|-----------|----------|-------------------|
| 1          | John      | Doe      | 5                 |
| 2          | Jane      | Smith    | 10                |
| 3          | Emily     | Johnson  | 15                |

## Constraints
- The output should include only employees that have assisted customers
- Sort the results by the number of customers assisted in ascending order
