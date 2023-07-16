<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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

<style>
body {
	background-color: rgb(248, 244, 240);
}

.container-fluid {
	background-color: rgb(248, 244, 240);
	text-align: center;
}

.jumbotron {
	background-color: rgb(248, 244, 240);
	text-align: center;
}
</style>

<script type="text/javascript" src="/resources/js/model.js">
	
</script>


<title>Model</title>
</head>

<body>
	<div class="container-fluid">
		<form action="addmodel">
			<div class="form-group position-relative">
				<label for="inputName">Name</label> <input type="text"
					class="form-control " id="inputName" placeholder="Name" name="name">
				<div class="invalid-tooltip" id="username_error_message"></div>


				<!-- <div class="valid-tooltip">Good! Your email address looks valid.</div> -->

			</div>
			<div class="form-group position-relative">
				<label for="inputColor">Colour</label> <input type="text"
					class="form-control " id="inputColor" placeholder="Colour"
					name="color">
				<div class="invalid-tooltip" id="color_error_message"></div>
			</div>


			<div class="form-group position-relative">
				<label for="inputPrice">Price</label> <input type="text"
					class="form-control " id="inputPrice" placeholder="Price"
					name="price">
				<div class="invalid-tooltip" id="price_error_message"></div>
			</div>

			<div class="form-group position-relative">
				<label for="inputCapacity">Quantity</label> <input type="text"
					class="form-control " id="inputCapacity" name="quantity" placeholder="4">
				<div class="invalid-tooltip" id="capacity_error_message"></div>
			</div>

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
	</div>
</body>

</html>