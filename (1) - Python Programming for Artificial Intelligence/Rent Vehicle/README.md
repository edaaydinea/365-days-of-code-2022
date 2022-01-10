# Rent Vehicle Object - Oriented Program Final Project

*Author: Eda AYDIN*

**Aim of project:** This program includes two different types of car rental and car return operations (car and bike).

This program was written in the **Artificial Intelligence for Python Programming** course through the **DATAI Team**.

There are two main classes in this program.

**[rent.py](https://github.com/edaaydinea/365-days-of-code/blob/main/(1)%20-%20Python%20Programming%20for%20Artificial%20Intelligence/Rent%20Vehicle/rent.py) :** It is a Python file that contains the codes about how the program will run in the background.

**1. Vehicle Class**
- Vehicle class is a *parent, super class*. Information about how many vehicles we have, car rental information about whether the vehicles will be purchased hourly or daily, and invoice information when customers want to return their vehicles are included.

    **a. Car Rental Class**
    - This class is a *subclass of Vehicle Class*.
    - This class has different operations on the variable such as stock and discount rate, which are inherited from the Vehicle Class.

    **b. Bicycle Rental Class**
    - This class is a *subclass of Vehicle Class*.
    - This class has different operations on the variable such as stock, which is inherited from the Vehicle Class.

**2. Customer Class**
- The customer class includes information that we will ask for hourly or daily vehicles of the customer, and the hourly and daily rental and return time differences for the vehicles bought hourly and daily.


**[main.py](https://github.com/edaaydinea/365-days-of-code/blob/main/(1)%20-%20Python%20Programming%20for%20Artificial%20Intelligence/Rent%20Vehicle/main.py) :** It is a Python file that contains the codes for showing how the program will work on the user side.
