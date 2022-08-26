# Feyline Feasts Api  <br />
## Project 1<br />
Khalis Bell<br />
Nickolas Earles<br />
 

## The Goal
<br />

The goal of Our App is to develop a funtional api for a theroetical small resturant in order to improve the resturant's productivity. <br />
The app is planed to have the ability for customers to place orders throught the app.<br />
An admin side will exist so the owners can add, update and remove items from the menue.<br />
This app will leverag RESTful design using an embedded tomcat server to handle incoming requests<br />
to thoroughly tested services that must be persisted using Hibernate and AWS PostgreSQL services.<br />



## how to use it<br />
-http://localhost:8080/auth<br />
----Post   (json{"username":"String","password":"String"}) <br />
----Delete <br />
-http://localhost:8080/user<br />
----Get    (Param{?username=username})<br />
----Get    admin()<br />
----Post   (json{"username":"String","fname":"String","lname":"String","password":"String","dob":date,"admin":Boolean})<br />
----Put    (json{"id":"username","field_to_edit":"field"})<br />
----Delete ({"id":"username"})<br />
-http://localhost:8080/pay<br />
----Get    (Param{?paymentid=paymentid}) <br />
----Get    admin()<br />
----Post   (json{"balance":"double","expDate":"String","ccv":"int","zipCode":"int"})<br />
----Put    (json{"id":"paymentid","field_to_edit":"field"})<br />
----Delete (json{"id":"paymentid"})<br />
-http://localhost:8080/order<br />
----get    (Param{?id=orderid})<br />
----post   (json{"amount":int,"orderDate": date,"orderAddress": "String","orderZip": int,"paymentId":paymentid})<br />
----put    (json{"id":"orderid","field_to_edit":"field"})<br />
----Delete (json{"id":paymentid})<br />
-http://localhost:8080/orderdetail<br />
----get    (Param{?id=orderDetailid})<br />
----post   (json{"dishId":dishId,"orderId":orderId,"quantity":int,"comments": "String"})<br />
----put    (json{"id":"orderDetailId","field_to_edit":"field"})<br />
----Delete (json{"id":orderDetailId})<br />
-http://localhost:8080/dish<br />
----get all()<br />
----get    (Param{?id=dishid})<br />
----post   admin(json{"dishName": "test Truffle","cost": 15.0,"description": "desc text 02","isVegetarian": true})<br />
----put    admin(json{"dishId": dishId,"field_to_edit":"field"})<br />
----Delete admin(json{"dishId": dishId})<br />

## Technologies used (with versions)
IntelliJ Comunity 2022.1.4
<br />
Hibernate 5.6.10.Final
<br />
Maven
<br />
JSON
<br />
Java 8 
<br />
Postgres SQL 42.3.3
<br />
Apache Tomcat 8.5.23
<br />
Jackson 2.13.3
<br />
## ERD
![]([img/p1-erd.png](https://github.com/Stacks-OnStacks/assignments/blob/fdebc152226132a6d945deb45a8b45aef0d32fb4/img/p1-erd.png))


## how to initialize it
set up a Hibernate.propererties file to conect to a database then just run the program

## features 

### As A: Admin

    Create/Update/Delete a dish

### As A: Customer

    View all dishes at the restaurant without needing to Register or Login
    Register/Update/Delete an account
    Add/Update/Delete my payment info
    Create/Update an order only if Registered & Logged in
    Once I order, balance is removed based on the amount in the order
    Add any comments for substitutions to the order details
    View all past orders


## contributers
Khalis Bell<br />
Nickolas Earles
