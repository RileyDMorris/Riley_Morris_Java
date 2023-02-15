-- Below are my answers to the 9 queries. I added comments wherever there was any confusion

-- Question 1: What are the categories of products in the database?
use northwind;
select category -- I don't think this needs a distinct keyword. There are a lot of duplicates though
from products;

-- Question 2: What products are made by Dell?
use northwind;
select *
from products
where product_name like "%Dell%"; -- I assume that all Dell products have "Dell" in the name. There was no manufacturer column

-- Question 3: List all the orders shipped to Pennsylvania.
use northwind;
select *
from orders
where ship_state = 'Pennsylvania';

-- Question 4: List the first name and last name of all employees with last names that start with the letter W.
use northwind;
select first_name, last_name
from employees
where last_name like 'W%';

-- Question 5: List all customers from zip codes that start with 55.
use northwind;
select *
from customers
where postal_code like '55%';

-- Question 6: List all customers from zip codes that end with 0.
use northwind;
select *
from customers
where postal_code like '%0';

-- Question 7: List the first name, last name, and email for all customers with a ".org" email address.
use northwind;
select first_name, last_name, email
from customers c
where email like '%.org';

-- Question 8: List the first name, last name, and phone number for all customers from the 202 area code.
use northwind;
select first_name, last_name, phone
from customers c
where phone like '%(202)%';

-- Question 9: List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
use northwind;
select first_name, last_name, phone
from customers c
where phone like '%(202)%'
order by last_name, first_name;
