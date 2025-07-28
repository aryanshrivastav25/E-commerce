<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h2>Add, world</h2> <br>
        <%--
             <%= session.getAttribute("result") %>
            equal sign is to get the value returned by the getAttribute() function
            Syntax: <%= %> and not <% = %>
            Otherwise we can use jstl way which  ${variable_name}, the variable_name is assigned to the jsp page using the Session
        --%>

        <h2>Result is: ${result}</h2>
    </body>
</html>