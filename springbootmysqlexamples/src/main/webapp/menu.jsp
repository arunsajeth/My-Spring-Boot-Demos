<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>

        /* Global Styles */

        body {

            margin: 0;

            padding: 0;

            font-family: Arial, sans-serif;

            background-color: white;

            color: black;
            
            text-align: center;

        }

 

        /* Navigation Bar */

        .navbar {

            background-color: #333;

            overflow: hidden;

        }

 

        .navbar a {

            float: left;

            font-size: 16px;

            color: #fff;

            text-align: center;

            padding: 14px 16px;

            text-decoration: none;

        }

 

        /* Sidebar Styles */

        .sidebar {

            height: 100%;

            width: 250px;

            position: fixed;

            top: 0;

            left: -250px;

            background-color: #111;

            transition: left 0.3s ease-in-out;

        }

 

        .sidebar a {

            padding: 15px 25px;

            text-align: left;

            text-decoration: none;

            font-size: 18px;

            color: #fff;

            display: block;

            transition: background-color 0.3s;

        }

 

        .sidebar a:hover {

            background-color: #444;

        }

 

        /* Content Area */

        .content {

            margin-left: 0;

            padding: 20px;

            transition: margin-left 0.3s ease-in-out;

        }

 

.content.active {

            margin-left: 250px;

        }

 

        /* Movie Cards (Sample) */

        .movie-card {

            float: left;

            width: 200px;

            margin: 20px;

        }

 

        /* Add more styles for movie cards, images, and other elements as needed */

    </style>

</head>

<body>

 

<div class="navbar">

    <a href="/">Home</a>

    <a href="/create">Create</a>

    <a href="/view">View</a>

    <a href="/search">Search</a>

</div>

 

</body>

</html>