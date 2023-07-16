<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Register</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="css/mdb.min.css">
<link rel="stylesheet" href="css/modules/animations-extended.min.css">

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
		style="background-image: url('https://autopilothq.com/uploads/2017/03/20170329-shopping-1-large.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<!-- Main Navigation -->
		<header> </header>
		<main>

			<section class="section team-section">
				<div class="row text-center">
					<div class="col-md-1 mb-4"></div>
					<div class="col-md-10 mb-4">
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
	$(document)
			.ready(
					function() {
						// SideNav Initialization
						new WOW().init();
						$(".button-collapse").sideNav();
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
												+ "registerPassenger",

										
										data : passengerData,
									
										processData : false,
										contentType : false,
										cache : false,
										success : function(result) {
											var post = "<p>"
													+ "Registration Successfull! <br>"
													+ "Passenger's Info:<br> Passenger ID = "
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
													+ result.email + "</p>";
													
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