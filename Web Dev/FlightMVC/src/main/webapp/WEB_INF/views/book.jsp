<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Team</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- MDB icon -->
<link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="/resources/css/mdb.min.css">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="/resources/css/style.css">
<style>
body {
	background-color: #2e2e2e;
}

.text-poppy-red {
	color: #ef5350 !important;
}

.btn-poppy-red {
	background-color: #ef5350 !important;
}

.bg-poppy-red {
	background-color: #ef5350 !important;
}

</style>
</head>

<body>
 
  <div class = "container">
	<!-- Start your project here-->
	<div class="card ">

		<h5 class="card-header info-color white-text text-center py-4">
			<strong>Booking</strong>
		</h5>

		<!--Card content-->
		<div class="card-body px-lg-5 ">

			<!-- Form -->
			<form class="text-center" style="color: #757575;" action="bookflight">

				<p>Booking Registration</p>
				<!-- Name -->
	  	<!-- select team-->
     <label for="team"></label>
     <select class="browser-default custom-select mb-1 col-sm-2"  name="flightname">
        <option value="" disabled="" selected="">Choose Flight</option>
        <c:forEach var="flight" items="${flightList}">
            <option value="${flight.name}"> ${flight.getName()}
            </option>
        </c:forEach>
     </select>

        <br> 

         <br>

        	<!-- select team-->
     <label for="team"></label>
     <select class="browser-default custom-select mb-1 col-sm-2"  name="customerId">
        <option value="" disabled="" selected="">Choose Customer</option>
        <c:forEach var="customer" items="${customerList}">
            <option value="${customer.id}"> ${customer.getId()}
            </option>
        </c:forEach>
     </select>

        <br>
        
        	<!-- Submit button -->
				<div class="row">
					<div class="col-sm-5"></div>
					<button
						class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect col-sm-2"
						type="submit" id="button">Book Flight</button>
        </div>

			
      </form>
				</div>
		
			<!-- Form -->
			 
		</div>
  </div>

	<!-- End your project here-->

	<!-- jQuery -->
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="/resources/js/mdb.min.js"></script>
	<!-- Your custom scripts (optional) -->
	<script type="text/javascript">
    
    </script>
</body>

</html>