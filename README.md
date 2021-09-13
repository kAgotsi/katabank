Technologies used:

Spring boot 2.5.2
Spring data
Mysql as database

Aspect-Oriented Programming:
I used aspect-oriented programming to handle exceptions.


API:
POST /api/account : create a new bank account
POST /api/client : create a new customer account

POST /api/operations/deposit : make deposit in account
POST /api/operations/withdrawal : make withdrawal in account

POST /api/operations/: Get all operation

* **Test** *:
Scenario:
To test:
0. Create database on mysql server : kata_bank
1. Create a client
2. Create an account for client
3. Make a deposit / withdrawal in account
4. Get all operations by account
To test, you can use the curl or Postman command.

please find all curl request in file request.

Demo:
you will find a demo file here :
https://youtu.be/EsBue432cmg

