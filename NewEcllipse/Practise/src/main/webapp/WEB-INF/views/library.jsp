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
		style="background-image: url('https://i.pinimg.com/originals/f8/b7/c9/f8b7c978baf20ee116fb339b370c8574.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
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
										Register- <span class="text-muted">Register Library</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="libraryform">
									<!-- Name -->
									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="text" id="libraryname" class="form-control "
													name="name"> <label for="libraryname">
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
										<div class="col-lg-4">Type</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="type" type="radio"
												value="digital" id="radio1"> <label
												class="form-check-label" for="radio1">Digital</label>
										</fieldset>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<fieldset class="form-check mb-0">
											<input class="form-check-input" name="type" type="radio"
												id="radio2" value="non-digital"> <label
												class="form-check-label" for="radio2">Non Digital</label>
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
										<div class="col-lg-4">NewsPapers</div>
									</div>
									<br>
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="newspapers"
												value="Times Of India"> <span class="lever"></span>Times Of India
												
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="newspapers"
												value="The Hindu"> <span class="lever"></span> The Hindu
												
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="newspapers"
												value=" Hindusthan Times"> <span class="lever"></span> Hindusthan Times
												
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="newspapers"
												value="Deccan Chronicle"> <span class="lever"></span>Deccan Chronicle
											</label>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="switch">
											<label> <input type="checkbox" name="newspapers"
												value="NavBharath Times"> <span class="lever"></span>NavBharath Times
												
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
								$("#libraryform").submit(function(event) {
									event.preventDefault();
									ajaxPost();
								});
								function ajaxPost() {
									// Get form
									var form = $('#libraryform')[0];
									
									
									var libraryData = new FormData(form);

									$
											.ajax({
												type : "POST",
												enctype : 'multipart/form-data',
												//contentType: "application/json",
												//url: '${pageContext.request.contextPath}/registeruser',

												url : "http://localhost:8080/"
														+ "createlibrary",

												//data: JSON.stringify(productData),
												data : libraryData,
												//dataType: 'json',
												processData : false,
												contentType : false,
												cache : false,
												success : function(result) {
													var post = "<p>"
															+ "Registration Successfull! <br>"
															+ "Library's Info:<br> Library ID = "
															+ result.id
															+ "<br> Library Name = "
															+ result.name
															+ "<br> Library Type = "
															+ result.type
															+ "<br> Library NewsPapers = "
															+ result.newspapers
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
													

												},
												
												error : function(e) {
													//alert("Error!")

													responseText = jQuery
															.parseJSON(e.responseText);
													console
															.log(
																	"ERROR: ",
																	responseText.message);
													//console.log(exception);

													var post = "<p>"
															+ "OOps !! There was an exception!! <br>"
															+ responseText.message
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
													$("#registerpost").html(close);
													
												}
												
											});

									// Reset FormData after Posting

								}
							});
		</script>
	</div>
</body>

</html>