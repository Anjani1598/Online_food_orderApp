# Food delivery app backend
This repository contains the backend of a food delivery app. An online food delivery app aims to deliver food from restaurants to customers at a location of their choice in a safe, fast and efficient manner. This combines convenience of the customer with a manifold increase in the reach of a restaurant. To do this, it involves onboarding restaurants, delivery agents and customers.  Online food delivery apps are a successful business model, two of the most famous examples are Zomato and Swiggy. In this model, we have divided the use for two separate users, the customer ordering the food, and the restaurant owner setting up and updating a restaurant menu.



## Team
[Anjani vara prasad](https://github.com/Anjani1598) (Team Lead)

[Vaibhav shahi](https://github.com/vaibhavshahi10)

[Kousik Manik](https://github.com/Kousik1234)

[Rishon A Singh](https://github.com/Rishon-A-Singh)


<h1 align="center">Swiggato</h1>

<h2 align="center">It's an E-commerce food web application with all the major functionalities. We build this project taking inspiration from Swiggy and Zomato</h2>
PalletLogo
![PALLET logo](https://user-images.githubusercontent.com/102143515/234801628-d80af5fa-5bdc-4669-8dc4-dc42892829c2.png)

<br />
<p align="center">
    <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" alt="html"/>
    <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="css3"/> 
    <img src="https://img.shields.io/badge/JavaScript-323330?style=for-the-badge&logo=javascript&logoColor=F7DF1E" alt="JavaScript" />
    <img src="https://img.shields.io/badge/Rest_API-02303A?style=for-the-badge&logo=react-router&logoColor=white" alt="restAPI"/>
</p>

## 🚀 ER Diagram


![Online Food Order](https://user-images.githubusercontent.com/102143515/203010142-d786985d-1551-46b5-9dfd-cfe6defb21f9.png)


<p align="center"> 
    <br />&#10023;
    <a href="#Demo">View Demo</a>   &#10023;  
    <a href="https://github.com/Anjani1598/Online_food_orderApp/issues">Report Bug</a>    &#10023;
    <a href="#Getting-Started">Getting Started</a> &#10023; <a href="#Install">Installing</a> &#10023;    
    <a href="#Contact">Author</a> &#10023;
  </p>
  
  Food-Store is an e-commerce food web application that allows you to food online. It has a variety of categories, just visit the food listing page, trending food page or search page and you will see all the food available, apply sorting as per your need and in just a few clicks you can order food from the website.
  
 
  
  ![Food Store poster](https://user-images.githubusercontent.com/102143515/202909528-ed346802-55cb-493b-9c3b-321a4c4df3d0.png)

  <br />
  
  
<br />

## 🚀 Features

- Login/Signup User Account
- Homepage
   - Restaurant Listing Page with Sorting Filters
   - SortBy Rating, DeliveryTime, Great Offers 
   - Location Search Bar
   - Restaurant, item and more Search Bar
- Items Page
   - Item Page with categories
- Cart Page
   - Cart page with Checkout Component
   - Login / Logout
   - Signup
- User Authentication before placing an order
- ProfilePage
    - View Orders 
    - User Details
    

<br />

## Glimpses of Mini-Store 🙈 :

<table>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/102143515/202907333-9ad3d84b-4e67-43be-80f3-98166ad6ca4a.png" alt="home" /></td>
    <td><img src="https://user-images.githubusercontent.com/102143515/202907389-7d2c181f-577a-4a6d-aead-40dd4755558a.png" alt="food" /></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/102143515/202907396-35bf7f6b-363d-4e6d-88e1-b72b582cc22b.png" alt="trending" /></td>
    <td><img src="https://user-images.githubusercontent.com/102143515/202907432-19eff706-dbb3-4dbc-bf17-35c0fd7b2e73.png" alt="search" /></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/102143515/202907516-bc8586a8-f31f-4581-b8f0-0309af3c37ed.png" alt="cart" /></td>
    <td><img src="https://user-images.githubusercontent.com/102143515/202907550-696e2766-907b-447d-a724-622ce86a95df.png" alt="signup" /></td>
  </tr>
</table>

<br />



## Demo

### [Click here to see the presentation of this project](https://www.linkedin.com/posts/m-sehrawat_html-css-javascript-activity-6942859963576766464-BzQM?utm_source=linkedin_share&utm_medium=member_desktop_web)

<br/>

## Getting Started

This project was built using HTML5, CSS3, JavaScript, Rest API. It is an e-commerce food web application and for running on your local environment you should follow these guidelines.


## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per your local database config.
```
   server.port=8880
   spring.datasource.url=jdbc:mysql://localhost:3306/onlineFoodOrderdb
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.username=**mysql username**
   spring.datasource.password=**YourPassword**
   spring.jpa.hibernate.ddl-auto=update
```

# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring Security
-   Spring Boot
-   Hibernate
-   MySQL






# Backend

## Customer Controller

#### POST : http://localhost:8880/customers?key=FKGj8G

```
{
  "customerId": 198,
  "firstName": "jack",
  "lastName": "tony",
  "age": 21,
  "gender": null,
  "mobileNumber": "8500016899",
  "password": "jack",
  "address": [
    {
      "buildingName": "Gachibowli Hyderabad",
      "streetNo": "11.=45",
      "area": "Gachibowli",
      "city": "Hyderabad",
      "state": "Telangana",
      "country": "India",
      "pincode": "5330002"
    }
  ],
  "email": "jack@gmail.com"
}



## Restaurant Controller

#### GET : http://localhost:8880/restaurants
 Part 2
```
**Response**

[
  {
    "restaurantId": 2,
    "restaurantName": "KFC",
    "rating": 2.96928,
    "deliveryTime": 46.4409,
    "discount": 48,
    "city": "Hyderabad",
    "address": [
      {
        "buildingName": "Eswari Hyderabad",
        "streetNo": "467-7",
        "area": "Eswari",
        "city": "Hyderabad",
        "state": "Telangana",
        "country": "india",
        "pincode": "533002"
      }
    ],
    "restaurantThumbnail": "https://b.zmtcdn.com/data/pictures/chains/5/90195/d11c62568ac4df7d492db35abaae2c8a_featured_v2.jpg?fit=around%7C108%3A108&crop=108%3A108%3B%2A%2C%2A",
    "managerName": "Navya",
    "mobileNumber": "8500016898",
    "password": "kfc"
  },
  {
    "restaurantId": 3,
    "restaurantName": "Hotel Shadhab",
    "rating": 1.1438,
    "deliveryTime": 45.8845,
    "discount": 31,
    "city": "Hyderabad",
    "address": [
      {
        "buildingName": "Seeram Anjani vara prasad Hyderabad",
        "streetNo": "62-1-18",
        "area": "Seeram Anjani vara prasad",
        "city": "Hyderabad",
        "state": "Telangana",
        "country": "India",
        "pincode": "533001"
      }
    ],
    "restaurantThumbnail": "https://b.zmtcdn.com/data/pictures/chains/1/91711/f3704598c336542166b781026fc5ad4b_o2_featured_v2.jpg?output-format=webp",
    "managerName": "Kishore",
    "mobileNumber": "7702464241",
    "password": "kishore"
  },
  {
    "restaurantId": 4,
    "restaurantName": "Shah Ghouse",
    "rating": 3.5617,
    "deliveryTime": 46.6191,
    "discount": 12,
    "city": "Hyderabad",
    "address": [
      {
        "buildingName": "Seeram Anjani vara prasad Hyderabad",
        "streetNo": "62-1-18",
        "area": "Seeram Anjani vara prasad",
        "city": "Hyderabad",
        "state": "Telangana",
        "country": "India",
        "pincode": "533001"
      }
    ],
    "restaurantThumbnail": "https://b.zmtcdn.com/data/pictures/chains/0/93970/ff2a033de7e1e643935b8899a1e2b42e_o2_featured_v2.jpg?output-format=webp",
    "managerName": "madhu",
    "mobileNumber": "8247341447",
    "password": "madhu"
  },
  {
    "restaurantId": 5,
    "restaurantName": "Grand Hotel",
    "rating": 4.99629,
    "deliveryTime": 54.4579,
    "discount": 12,
    "city": "Hyderabad",
    "address": [
      {
        "buildingName": "Seeram Anjani vara prasad Hyderabad",
        "streetNo": "62-1-18",
        "area": "Seeram Anjani vara prasad",
        "city": "Hyderabad",
        "state": "Telangana",
        "country": "India",
        "pincode": "533001"
      }
    ],
    "restaurantThumbnail": "https://b.zmtcdn.com/data/pictures/chains/0/92020/3088315ab85025468fb789f2871bf131_o2_featured_v2.jpg?output-format=webp",
    "managerName": "rishi",
    "mobileNumber": "9703432689",
    "password": "rishi"
  },
  {
    "restaurantId": 6,
    "restaurantName": "Cafe 555",
    "rating": 2.43607,
    "deliveryTime": 27.8299,
    "discount": 48,
    "city": "Vishakapatnam",
    "address": [
      {
        "buildingName": "Seeram Anjani vara prasad Vishakapatnam",
        "streetNo": "62-1-18",
        "area": "Seeram Anjani vara prasad",
        "city": "Vishakapatnam",
        "state": "Andhra Pradesh",
        "country": "India",
        "pincode": "533001"
      }
    ],
    "restaurantThumbnail": "https://b.zmtcdn.com/data/pictures/chains/2/90042/449170ddb062657a49bd36b6957c4418_o2_featured_v2.jpg?output-format=webp",
    "managerName": "Nikith",
    "mobileNumber": "9848277809",
    "password": "rishi"
  },
]

## Swagger UI
<br />

## REST API's 🙈 :

<table>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/102143515/202918015-29efd9a5-1cc4-4477-b4c3-ad749fe10181.png" alt="home" /></td>
    <td><img src="https://user-images.githubusercontent.com/102143515/202918216-ded2ee39-4ac2-4481-9593-276d010c0e9a.png" alt="food" /></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/102143515/202918218-3b06f2e6-4c62-45ba-98cd-bd632fc9f6f5.png" alt="trending" /></td>
    <td><img src="https://user-images.githubusercontent.com/102143515/202918219-8ddeab4d-3fbc-432d-98ee-f2886f55f0b1.png" alt="search" /></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/102143515/202918220-8420b5ae-085a-4b12-b5a7-f42552fd0acb.png" alt="cart" /></td>
    <td><img src="https://user-images.githubusercontent.com/102143515/202918221-04d35ad9-d143-4e21-83e8-0df67897792c.png" alt="signup" /></td>
  </tr>
</table>

<br />



### Prerequisites

- NPM
- Node JS

### Setup

The project repository can be found in [GitHub link](https://github.com/Anjani1598/Online_food_orderApp) or just clone the project using this command.

```
Using HTTPS

# git clone  https://github.com/Anjani1598/Online_food_orderApp.git
```

- Open terminal on your workspace with

```

```

## Install

Install NPM

Check that you have node and npm installed

To check if you have Node.js installed, run this command in your terminal:

```
node -v
```

To confirm that you have npm installed you can run this command in your terminal:

```
npm -v
```

To run the application open index.html in the live server.

### Tools used on this project

- Visual Studio Code

<br/>

## Contact

If you want to contact me, you can reach me through below handles.

[![linkedin](https://img.shields.io/badge/Anjani-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/anjani1632/)
[![Github](https://img.shields.io/badge/AnjaniVaraPrasad-20232A?style=for-the-badge&logo=Github&logoColor=white)](https://github.com/Anjani1598)

© 2022 Anjani vara prasad

## Show your support

Give a ⭐️ if you like this project!
