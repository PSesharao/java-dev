<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot</title>
</head>
<body>
  
   
    <table align = "center", width = "50%"  cellpadding = "20%" border="1">
        <tr>
            <td> Username </td>
            <td> ${username} </td>
        </tr>

        <tr>
            <td> Password </td>
            <td> ${password}  </td>
        </tr>

        <tr>
            <td> Food </td>
            <td> ${food}   </td>
        </tr>

        <tr>
            <td> Hobbies </td>
            <td><c:forEach var="hb" items="${hobby}">
                <c:out value="${hb}" />  <br>
           </c:forEach> </td>
        </tr>
        
    </table>
</body>
</html>