<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Train</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="../../css/mdb.min.css">
<link rel="stylesheet"
	href="../../css/modules/animations-extended.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Your custom styles (optional) -->
<style>
.navbar {
	z-index: 1;
}

.view {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body class="fixed-sn white-skin">
	<div class="view jarallax" data-jarallax='{"speed": 0.2}'
		style="background-image: url('https://images5.alphacoders.com/728/728126.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<!-- Main Navigation -->
		<header>
			<!-- Navbar -->
			<nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
				<a class="navbar-brand" href="#"><strong>Train Application</strong></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item "><a class="nav-link" href="/home"
							id="homelink">Home </a></li>
						<li class="nav-item"><a class="nav-link" href="/city"
							id="playerlink">Add City</a></li>
						<li class="nav-item"><a class="nav-link" href="/train"
							id="teamlink">Add Train</a></li>
						<li class="nav-item"><a class="nav-link" href="/passenger"
							id="showlink">Add Passenger</a></li>
						<li class="nav-item"><a class="nav-link" href="/approve"
							id="showlink">Approve Request</a></li>
					</ul>
				</div>
			</nav>
			<!-- Navbar -->
		</header>
		<main>

			<section class="section team-section">
				<div class="row text-center">
					<div class="col-md-8 mb-4">

						<!-- Card -->
						<div class="card card-cascade cascading-admin-card user-card">

							<!-- Card Data -->
							<div class="admin-up d-flex justify-content-start">
								<i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
								<div class="data">
									<h5 class="font-weight-bold dark-grey-text">
										Register- <span class="text-muted">Register Train</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="passengerform">


									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="text" id="passengername" class="form-control "
													name="name"> <label for="passengername">Train
													Name</label>
											</div>
										</div>
									</div>

									<br>
									
								
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<select class="mdb-select md-form" searchable="Search here.."
												id="sourceDropdown" name="source">

											</select>
										</div>
									</div>

									<br>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<select class="mdb-select md-form" searchable="Search here.."
												id="destinationDropdown" name="destination">

											</select>
										</div>
									</div>

									<br>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form">
												<input placeholder="Selected date" type="text"
													id="date-picker-example"  name="date" class="form-control datepicker">
												<label for="date-picker-example" class="active">Date Of 
													Journey</label>
											</div>
										</div>
									</div>
									
									<br>
									
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
												type="submit" id="submitPassenger">Submit</button>
										</div>
									</div>

								</form>

								<div id="postInfo"></div>

							</div>
						</div>
					</div>
					<!-- Grid column -->
					<div class="col-md-4 mb-4">

						<!-- Card -->
						<div class="card profile-card">

							<!-- Avatar -->
							<div class="avatar z-depth-1-half mb-4">
								<img src="/uploads/${image}" class="rounded-circle"
									alt="First sample avatar image">
							</div>

							<div class="card-body pt-0 mt-0">

								<!-- Name -->
								<h3 class="mb-3 font-weight-bold">
									<strong>${name}</strong>
								</h3>
								<h6 class="font-weight-bold cyan-text mb-4">${email}</h6>

								<p class="mt-4 font-weight-bold cyan-text">${role}</p>


								<a href="/login?logout=true" class="btn btn-info btn-rounded"><i
									class="fas fa-sign-in-alt ml-1"></i> Logout </a>
							</div>

						</div>
						<!-- Card -->

					</div>
					<!-- Grid column -->
				</div>
			</section>
		</main>
	</div>
</body>

<script src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Custom scripts -->
<script>
	$
			.ajax({
				type : 'GET',

				url : "http://localhost:8080/" + "getCities",
				success : function(result) {

					var cityInfo = '<option value="" disabled selected>Source</option>';
					for (var i = 0; i < result.length; i++) {
						cityInfo += '<option value =' + result[i].city + '>'
								+ result[i].city + '</option>';
					}

					$('#sourceDropdown').html(cityInfo);

				}
			});

	$('#sourceDropdown').on('change', function() {
		createDestinationDropDown();

	});

	function createDestinationDropDown() {
		var source = $("#sourceDropdown option:selected").val();
		//console.log(source);

		$
				.ajax({
					type : 'GET',

					url : "http://localhost:8080/" + "getCities",
					success : function(result) {

						var cityInfo = '<option value="" disabled selected>Destination</option>';
						for (var i = 0; i < result.length; i++) {
							if(result[i].city == source) continue;
							cityInfo += '<option value =' + result[i].city + '>'
									+ result[i].city + '</option>';
						}


						$('#destinationDropdown').html(cityInfo);

					}
				});
	}
	
	$(document)
			.ready(
					function() {
						// SideNav Initialization
						new WOW().init();
						$(".button-collapse").sideNav();
						$('.mdb-select').materialSelect();
						$('.datepicker').pickadate();
						$("#passengerform").submit(function(event) {
							event.preventDefault();
							ajaxPost();
						});
						
						function ajaxPost() {

							var form = $('#passengerform')[0];

							var passengerData = new FormData(form);

							$
									.ajax({
										type : "POST",
										enctype : 'multipart/form-data',

										url : "http://localhost:8080/"
												+ "registerTrain",

										data : passengerData,

										processData : false,
										contentType : false,
										cache : false,
										success : function(result) {
											var post = "<p>"
													+ "Registration Successfull! <br>"
													+ "Train's Info:<br> Train ID = "
													+ result.id
													+ "<br> Train Name = "
													+ result.name
													
													+ "<br> Train Source = "
													+ result.source
													+ "<br> Train Destination = "
													+ result.destination
													+ "<br>Date of Journey = "
													+ result.date + "</p>";

											var close = '<div class="alert alert-primary alert-dismissible fade show"'+
								'role="alert">'
													+ '<strong>'
													+ post
													+ '</strong>'
													+ '<button type="button" class="close" data-dismiss="alert"'+
								'aria-label="Close">'
													+ '<span aria-hidden="true">&times;</span>'
													+ '</button> </div>';
											$("#postInfo").html(close);

										},
										error : function(e) {
											alert("Error!")
											console.log("ERROR: ", e);
										}
									});

						}
						
					});
</script>
</html>