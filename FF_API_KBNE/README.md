# Feyline Feasts Api  <br />
## Project 1<br />
Khalis Bell<br />
Nickolas Earles<br />
 

## The Goal
<br />

The goal of Our App is to develop a functional API for a theoretical small restaurant in order to improve the restaurant’s productivity. <br />
The app is planned to have the ability for customers to place orders through the app.<br />
An admin side will exist so the owners can add, update and remove items from the menu. <br />
This app will leverage RESTful design using an embedded tomcat server to handle incoming requests<br />
to thoroughly tested services that must be persisted using Hibernate and AWS PostgreSQL services. <br />



## how to use it<br />
### http://localhost:8080/auth<br />

        Post   (json{"username":"String","password":"String"}) 
        Delete 
### http://localhost:8080/user<br />

        Get    (Param{?username=username})
        Get    admin()
        Post   (json{"username":"String","fname":"String","lname":"String","password":"String","dob":date,"admin":Boolean})
        Put    (json{"id":"username","field_to_edit":"field"})
        Delete ({"id":"username"})
### http://localhost:8080/pay<br />

        Get    (Param{?paymentid=paymentid})
        Get    admin()
        Post   (json{"balance":"double","expDate":"String","ccv":"int","zipCode":"int"})
        Put    (json{"id":"paymentid","field_to_edit":"field"})
        Delete (json{"id":"paymentid"})
### http://localhost:8080/order
        
        get    (Param{?id=orderid})
        post   (json{"amount":int,"orderDate": date,"orderAddress": "String","orderZip": int,"paymentId":paymentid})
        put    (json{"id":"orderid","field_to_edit":"field"})
        Delete (json{"id":paymentid})
### http://localhost:8080/orderdetail<

        get    (Param{?id=orderDetailid})
        post   (json{"dishId":dishId,"orderId":orderId,"quantity":int,"comments": "String"})
        put    (json{"id":"orderDetailId","field_to_edit":"field"})
        Delete (json{"id":orderDetailId})
### http://localhost:8080/dish

        get    all()
        get    (Param{?id=dishid})
        post   admin(json{"dishName": "test Truffle","cost": 15.0,"description": "desc text 02","isVegetarian": true})
        put    admin(json{"dishId": dishId,"field_to_edit":"field"})
        Delete admin(json{"dishId": dishId})

## Technologies used (with versions)
        IntelliJ Community 2022.1.4
        Hibernate 5.6.10.Final
        Maven
        JSON
        Java 8 
        Postgres SQL 42.3.3
        Apache Tomcat 8.5.23
        Jackson 2.13.3
        
## ERD
![img/p1-erd.png](https://github.com/Stacks-OnStacks/assignments/blob/fdebc152226132a6d945deb45a8b45aef0d32fb4/img/p1-erd.png)


## how to initialize it
set up a Hibernate.properties file to connect to a database then just run the program

## features 

### As A: Admin

    Create/Update/Delete a dish

### As A: Customer

    View all dishes at the restaurant without needing to Register or Login
    Register/Update/Delete an account
    Add/Update/Delete my payment info
    Create/Update an order only if Registered & Logged in
    Once I order, balance is updated based on the amount in the order
    Add any comments for substitutions to the order details
    View all past orders


## contributors
Khalis Bell<br />
Nickolas Earles

