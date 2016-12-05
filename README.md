OOP. Practice Task 1
====================

[![Join the chat at https://gitter.im/changerequest/oop.pr1](https://badges.gitter.im/changerequest/oop.pr1.svg)](https://gitter.im/changerequest/oop.pr1?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

1 Fraction Number
-----------------

Create class FractionNumber which is fractional representation of any number.
What does it mean? Any number can be represented in following format: 1/4, 4/4, 10/3, etc. Your class should be able to work with such number representations. 

There are following requirements for this class:

1. class should contain dividend and divisor.
2. dividend and divisor should be normalized. Here are some examples of normalization:
    * dividend = 3, divisor = 9. Fraction Number should be 1/3
    * dividend = 9, divisor = 9. Fraction Number should be 1/1
    * dividend = 9, divisor = 3. Fraction Number should be 3/1
    * dividend = 9, divisor = -3. Fraction Number should be -3/1
    * dividend = -9, divisor = -3. Fraction Number should be 3/1
    * dividend = -9, divisor = 3. Fraction Number should be -3/1
    * dividend = 0, divisor = 3. Fraction Number should be 0/1
3. fraction number should be immutable. This means that there is no way to change the original value. 
4. divisor must not be 0
5. class should have such methods:
    * get dividend
    * get divisor
    * get decimal value. Example: dividend = 1, divisor = 4, decimal value for 1/4 = 0.25
    * to string method. Returns string in following format '1/4'
    * add another fraction number
    * subtract another fraction number
    * multiply by another fraction number
    * divide to another fraction number
6. there should be possibility to create fraction number with specifying only dividend. Default value for divisor value should be 1\.
7. create predefined objects ONE which is equal to 1/1 and ZERO which is equal to 0/1
    
Create demo class which demonstrates how all thing works.

2 Employees
-----------
Create class hierarchy Employees.
There should be 3 types of employees: Manager, Programmer, Accountant.
Every employee should be able to:

* set salary
* work specified amount of hours
* calculate current month salary
* get ratio of worked hours

Each employee should work **160** hours per month to get 100% of salary.
Employees salary depends on worked hours.
Programmers salary is directly proportional to the number of worked hours.
Accountant and Manager are the same, but get only 100% of salary in case of overtimes.
Accountant should be able to calculate overall salary for all accountable employees (including himself).

###### Examples:

* Programmer with salary 100$ worked 80 hours -> salary 50$
* Programmer with salary 100$ worked 320 hours -> salary 200$
* Accountant and Manager with salary 100$ worked 80 hours -> salary 50$
* Accountant and Manager with salary 100$ worked 320 hours -> salary 100$

Create demo class which demonstrates how all thing works.

3 Matrix
--------

Create class matrix. 
It should contains of:
 
* 2d array of real numbers 
* rows count 
* columns count

Matrix should be have such methods:
 
* add another matrix to this
* subtract another matrix from this
* multiply by a number
* multiply by another matrix https://en.wikipedia.org/wiki/Matrix_multiplication
* transposition of current matrix https://en.wikipedia.org/wiki/Transpose
* to string method

Create demo class which demonstrates how all thing works.
