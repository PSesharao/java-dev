<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   
   <head>
      <title>HTML Frames</title>
   </head>
   
   <frameset cols = "25%,*">
      <frame name = "left" src = "/home" />
      <frame name = "center" src = "/welcome" />
      <noframes>
         <body>Your browser does not support frames.</body>
      </noframes>
   </frameset>
   
</html>