<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->

<style>
.container {
	background-color: rgb(248, 244, 240);
}

.jumbotron {
	background-color: rgb(248, 244, 240);
	text-align: center;
}
</style>

<title>show</title>
</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<div class="form">
				<form action="/showbrand">

					<div class="form-group position-relative">
						<select class="mdb-select md-form" searchable="Search here.."
							name="brand" id="brand">
							<option value="" disabled selected>Choose Brand</option>
							<c:forEach var="brand" items="${brandList}">
								<option value="${brand.name}">${brand.getName()}</option>
							</c:forEach>
						</select>
						<div class="invalid-tooltip" id="brand_error_message"></div>
					</div>
					<button type="submit" class="btn btn-primary" id="button1">
						Submit</button>
				</form>
			</div> <br> <br>

			<div id="stdtable">
				<table align="center" , width="50%" cellpadding="20%"
					class="table table-striped">
					<tr>
						<th>Model Id</th>
						<th>Model Name</th>
						<th>Color</th>
						<th>Price</th>
						<th>Quantity</th>
					</tr>
					<c:forEach var="model" items="${modelList}">
						<tr>
							<td>${model.id}</td>
							<td>${model.name}</td>
							<td>${model.color}</td>
							<td>${model.price}</td>
							<td>${model.quantity}</td>

						</tr>
						
					</c:forEach>
					<tr>
							<td>
							Overall Revenue
							</td>
							<td>
							</td>
							<td>
							</td>
							<td>
							${revenue}
							</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>

</html>