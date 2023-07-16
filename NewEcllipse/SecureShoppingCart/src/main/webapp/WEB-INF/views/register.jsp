<!DOCTYPE html>
<html lang="en">

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
		<header>

			<!-- Navbar -->

			<!-- Navbar -->

		</header>
		<!-- Main Navigation -->

		<!-- Main layout -->
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
										Register- <span class="text-muted">Register Customer</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="customerform">
									<!-- Name -->
									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="text" id="customername" class="form-control "
													name="name"> <label for="customername">Customer
													Name</label>
											</div>
										</div>
									</div>
									<br>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="customername_error_message">
											</div>
										</div>
									</div>


									<!-- Gender -->
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">Gender</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="gender" type="radio"
												value="male" id="radio1"> <label
												class="form-check-label" for="radio1">Male</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="gender" type="radio"
												id="radio2" value="female"> <label
												class="form-check-label" for="radio2">Female</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="gender" type="radio"
												id="radio3" value="Not Specified"> <label
												class="form-check-label" for="radio3">Prefer Not to
												Say</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="gender_error_message">
											</div>
										</div>
									</div>

									<br> <br>
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
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="hobby_error_message">
											</div>
										</div>
									</div>




									<!-- Grid row -->
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
									<!-- Grid row -->

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="address_error_message">
											</div>
										</div>
									</div>

									<br>

									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="email" id="customeremail" class="form-control "
													name="email"> <label for="customeremail">
													Email </label>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="customeremail_error_message">
											</div>
										</div>
									</div>

									<br>

									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="password" id="customerpassword"
													class="form-control " name="password"> <label
													for="customerpassword"> Password </label>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip"
												id="customerpassword_error_message"></div>
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<label class="form-label" for="imageFile">Upload
												Photo</label> <input type="file" class="form-control" id="imageFile"
												name="imageFile">
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="customerimage_error_message">
											</div>
										</div>
									</div>

									<br>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">Roles</div>
									</div>

									<br>
									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="roles" type="checkbox"
												value="ADMIN" id="check1"> <label
												class="form-check-label" for="check1">Admin</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="roles" type="checkbox"
												id="check2" value="USER"> <label
												class="form-check-label" for="check2">User</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="roles" type="checkbox"
												id="check3" value="GUEST"> <label
												class="form-check-label" for="check3">Guest</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="role_error_message"></div>
										</div>
									</div>

									<br>

									<!-- Submit button -->
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
												type="submit" id="submitRegister">Submit</button>
										</div>
									</div>
								</form>
								
								<a href="/login" class="btn btn-info btn-rounded" ><i class="fas fa-sign-in-alt ml-1"></i> Log In </a>
								
								<div id="registerpost"></div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</main>
		<!-- Main layout -->


		<!-- SCRIPTS -->
		<!-- JQuery -->
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
								$("#customerform").submit(function(event) {
									event.preventDefault();
									ajaxPost();
								});
								function ajaxPost() {
									// Get form
									var form = $('#customerform')[0];
									console.log($('#imageFile').val());
									//return false;
									var customerData = new FormData(form);

									$
											.ajax({
												type : "POST",
												enctype : 'multipart/form-data',
												//contentType: "application/json",
												//url: '${pageContext.request.contextPath}/registeruser',

												url : "http://localhost:8080/"
														+ "registeruser",

												//data: JSON.stringify(productData),
												data : customerData,
												//dataType: 'json',
												processData : false,
												contentType : false,
												cache : false,
												success : function(result) {
													var post = "<p>"
															+ "Registration Successfull! <br>"
															+ "Customer's Info:<br> Customer ID = "
															+ result.id
															+ "<br> Customer Name = "
															+ result.name
															+ "<br> Customer Gender = "
															+ result.gender
															+ "<br> Customer Email = "
															+ result.email
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
													$("#registerpost").html(
															close);
													$("#registerpost").show();

												},
												error : function(e) {
													alert("Error!")
													console.log("ERROR: ", e);
												}
											});

									// Reset FormData after Posting

								}
							});
		</script>
	</div>
</body>

</html>