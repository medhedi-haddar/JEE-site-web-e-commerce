<%-- 
    Document   : logout
    Created on : 30 déc. 2014, 02:17:46
    Author     : hedi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body>
        <%
        
        session.invalidate();
        
        %>
        <jsp:forward page="index.jsp"></jsp:forward>
    </body>
</html>
