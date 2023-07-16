<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<ul >
		<li ><a href="/home">Home
				
		</a></li>
		
		<li ><a href="/user">User</a>
		</li>
		<li ><a href="/admin">Admin</a>
		</li>
	</ul>
	<ul>
		<li ><a 
			href="/login?logout=true">Logout</a></li>
	</ul>
	<h1>${message}</h1>
</body>
</html>