<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Passenger</title>
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
										Register- <span class="text-muted">Register Passenger</span>
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
													name="name"> <label for="passengername">Passenger
													Name</label>
											</div>
										</div>
									</div>


									<br>
									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="text" id="passengerage" class="form-control "
													name="age"> <label for="passengerage">Passenger
													Age</label>
											</div>
										</div>
									</div>
									<br>


									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">Favourite Food</div>
									</div>


									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="favouriteFood"
												type="radio" value="veg" id="radio1"> <label
												class="form-check-label" for="radio1">Veg</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="favouriteFood"
												type="radio" id="radio2" value="non-veg"> <label
												class="form-check-label" for="radio2">Non Veg</label>
										</fieldset>
									</div>

									<br>

									<!-- Gender -->
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">Gender</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="gender" type="radio"
												value="male" id="radio10"> <label
												class="form-check-label" for="radio10">Male</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="gender" type="radio"
												id="radio12" value="female"> <label
												class="form-check-label" for="radio12">Female</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="gender" type="radio"
												id="radio13" value="Not Specified"> <label
												class="form-check-label" for="radio13">Prefer Not to
												Say</label>
										</fieldset>
									</div>

									<br>


									<!-- Hobbies -->
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">Hobbies</div>
									</div>
									<br>
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="hobbyList"
												value="Playing Cricket"> <span class="lever"></span>Playing
												Cricket
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="hobbyList"
												value="Playing Chess"> <span class="lever"></span>Playing
												Chess
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="hobbyList"
												value="Book Reading"> <span class="lever"></span>Book
												Reading
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="hobbyList"
												value="Cooking"> <span class="lever"></span>Cooking
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="hobbyList"
												value="Watching Films"> <span class="lever"></span>Watching
												Films
											</label>
										</div>
									</div>
									<br>

									<div class="row">
										<div class="col-lg-4"></div>
										<!-- Grid column -->
										<div class="col-lg-4">

											<!-- Basic textarea -->
											<div class="md-form mb-0">
												<textarea type="text" name="address" id="address"
													class="md-textarea form-control" rows="3"></textarea>
												<label for="address">Address</label>
											</div>

										</div>
										<!-- Grid column -->

									</div>

									<br>

									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="email" id="passengeremail"
													class="form-control " name="email"> <label
													for="passengeremail"> Email </label>
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
										<div class="col-lg-4">Agreement</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="terms" type="checkbox"
												value="yes" id="check1"> <label
												class="form-check-label" for="check1">Agreed To
												Terms</label>
										</fieldset>
									</div>
									<br>
									<input type="hidden" name="trainId" id="trainId" >
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
												type="submit" id="submitPassenger">Request</button>
										</div>
									</div>

								</form>
								
								<div id="trainInfo"> </div>
								
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
			
			<section class="section team-section">
				<div class="row text-center">
					<div class="col-md-12 mb-4">
						<!-- Card -->
						<div class="card card-cascade cascading-admin-card user-card">

							<!-- Card Data -->
							<div class="admin-up d-flex justify-content-start">
								<i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
								<div class="data">
									<h5 class="font-weight-bold dark-grey-text">
										Trains - <span class="text-muted">Available Trains</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							
							<div class="card-body card-body-cascade">

								<div class="table-responsive">

									<table class="table product-table table-cart-v-1"
										id="traintable">

									</table>

								</div>
							</div>
							
						</div>
					</div>
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
	
	$('#destinationDropdown').on('change', function() {
		createTable();

	});
	
	function createTable() {
		var source = $("#sourceDropdown option:selected").val();
		var destination = $("#destinationDropdown option:selected").val();
		
		$
				.ajax({
					type : 'GET',

					url : "http://localhost:8080/"
							+ "getTriansBySourceAndDestination/" + source+"/"+destination,
					success : function(result) {
						
						var tableInfo = '';

						tableInfo += '<thead>' + '<tr>'
								+ '<th scope="col">Train Id</th>'
								+ '<th scope="col">Train Name</th>'
								+ '<th scope="col">Source</th>'
								+ '<th scope="col">Destination</th>'
								+ '<th scope="col">Date of Journey</th>'
								+ '</tr>' + '</thead>' + '<tbody>';

						for (var i = 0; i < result.length; i++) {

							tableInfo += '<tr>' + '<td>'
									+ result[i].id + ' </td>';
							tableInfo += '<td>' + result[i].name
									+ '</td>';
							tableInfo += '<td>' + result[i].source
									+ '</td>';
							tableInfo += '<td>' + result[i].destination
									+ '</td>';
							tableInfo += '<td>' + result[i].date
									+ '</td>';
							
							tableInfo += '<td>'
									+ '<button type="button"  value="'
									+  result[i].id
									+ '" name="key" onclick="bookTrain(this.value)" class="btn btn-primary">Book</button>'
									+ '</td>' + '</tr>'
						}
						tableInfo += '</tbody>';
						$("#traintable").html(tableInfo);

					}
				});
	}
	
	function bookTrain(trainId) {
		$('#trainId').val(trainId);
		var post = "<p>"
			+ "Below Train is going to be Booked<br>"
			
			+ " Train Id = "
			+ trainId + "</p>";

	var close = '<div class="alert alert-primary alert-dismissible fade show"'+
'role="alert">'
			+ '<strong>'
			+ post
			+ '</strong>'
			+ '<button type="button" class="close" data-dismiss="alert"'+
'aria-label="Close">'
			+ '<span aria-hidden="true">&times;</span>'
			+ '</button> </div>';
	$("#trainInfo").html(close);
		//console.log(trainId);
	}
	
	$(document)
			.ready(
					function() {
						// SideNav Initialization
						new WOW().init();
						$(".button-collapse").sideNav();
						$('.mdb-select').materialSelect();
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
										+ "makeRequest",

								data : passengerData,

								processData : false,
								contentType : false,
								cache : false,
								success : function(result) {
									var post = "<p>"
											+ "Request Successfull! <br>"
											+ "Request's Info:<br> Request ID = "
											+ result.id
											+ "<br> Passenger Name = "
											+ result.name
											+ "<br> Passenger Age = "
											+ result.age
											+ "<br> Passenger Gender = "
											+ result.gender
											+ "<br> Passenger Address = "
											+ result.address
											+ "<br> Passenger FavouriteFood = "
											+ result.favouriteFood
											+ "<br> Passenger Hobbies = "
											+ result.hobbyList
											+ "<br> Passenger Email = "
											+ result.email
											+ "<br> Train Id= "
											+ result.trainId
											+ "</p>";

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