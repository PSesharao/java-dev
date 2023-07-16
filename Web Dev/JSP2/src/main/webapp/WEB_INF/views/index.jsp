<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Spring Boot</title>
</head>
<body>
 
  <div class="form">
    <form action="/display" >
      	<table align = "center", width = "50%"  cellpadding = "20%">
		<tr>
			<td> 
				<b>User name:</b>
			</td>
				
			<td>
					<input type="text" name="username" id="username">
			</td>
		</tr>
		<tr>
			<td> 
				<b>Password:</b>
			</td>
				
			<td>
					<input type="text" name="password" id="password">
			</td>
		</tr>
		<tr>
			<td> 
				<b>Favourite Food:</b>
			</td>
				
			<td>
					<input type="radio" name="food" value="veg"> Veg <br>
					<input type="radio" name="food" value="nonvg"> Non Veg
			</td>
		</tr>
		   <tr>
			<td>
				<b>Hobbies:</b>
			</td>
			<td>
				<input type="checkbox" name="hobby" value="cricket"> Cricket <br>
				<input type="checkbox" name="hobby" value="book"> Book Reading <br>
				<input type="checkbox" name="hobby" value="music"> Music <br>
				<input type="checkbox" name="hobby" value="chess"> Chess <br>
				<input type="checkbox" name="hobby" value="carroms"> Carroms <br>
			</td>
		</tr>
		<tr>
			<td>
				
			</td>
			<td>
				<input type="submit" value="Submit" >
			</td>
		</tr>
	</table>
    </form>
  </div>

</body>
</html>