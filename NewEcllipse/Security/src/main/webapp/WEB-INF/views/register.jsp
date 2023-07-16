<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<form action="/registeruser" method='POST'>
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type='text' name='name' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='text' name='password' ></td>
			</tr>
			<tr>
				<td>Role</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="roles" value="ADMIN">
					Admin <br> <input type="checkbox" name="roles" value="USER">
					User <br> <input type="checkbox" name="roles" value="GUEST">
					Guest</td>

			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" ></td>
			</tr>
		</table>

	</form>
</body>
</html>