<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h2>Hello, world</h2>
        <form action="add">
            <label for="num1">Enter 1st number: </label>
            <input type="text" id="num1" name="num1"> <br>
            <label for="num2">Enter 2nd number: </label>
            <input type="text" id="num2" name="num2"> <br>
            <input type="submit" value="Submit"> 
        </form>

        <form action="addAlien">
            <label for="aid">Enter ID: </label>
            <input type="text" id="aid" name="aid"> <br>
            <label for="aname">Enter name: </label>
            <input type="text" id="aname" name="aname"> <br>
            <input type="submit" value="Submit"> 
        </form>
    </body>
</html>