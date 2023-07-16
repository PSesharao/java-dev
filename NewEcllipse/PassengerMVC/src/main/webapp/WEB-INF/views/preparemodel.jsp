<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Prepare Model</title>
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
		style="background-image: url('https://i.pinimg.com/originals/f8/b7/c9/f8b7c978baf20ee116fb339b370c8574.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<!-- Main Navigation -->
		<header>

			<!-- Navbar -->
			<nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
				<a class="navbar-brand" href="#"><strong>Shopping Mall</strong></a>
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
						<li class="nav-item"><a class="nav-link" href="/color"
							id="playerlink">Add Color</a></li>
						<li class="nav-item"><a class="nav-link" href="/brand"
							id="teamlink">Add Brand</a></li>
						<li class="nav-item"><a class="nav-link" href="/model"
							id="showlink">Add Model</a></li>
						<li class="nav-item"><a class="nav-link" href="/preparemodel"
							id="preparemodel">Prepare Model</a></li>
						<li class="nav-item"><a class="nav-link" href="/showroom"
							id="showlink">ShowRoom</a></li>
								<li class="nav-item"><a class="nav-link" href="/shop"
							id="showlink">Shop Now</a></li>
						<li class="nav-item"><a class="nav-link" href="/solditems"
							id="showlink">Sold Items</a></li>
					</ul>
				</div>
			</nav>
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
										Model- <span class="text-muted">Prepare Model</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="preparemodelform">
									<!-- Name -->

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<select class="mdb-select md-form" searchable="Search here.."
												id="brandDropdown" name="brand">

											</select>

										</div>
									</div>
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="brand_error_message">
											</div>
										</div>
									</div>
									<!-- class="mdb-select md-form" searchable="Search here.." -->
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<select class="mdb-select md-form" searchable="Search here.."
												id="modelDropdown" name="model">

											</select>

										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="model_error_message">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<select class="mdb-select md-form"
												
												searchable="Search here.." id="colorDropdown" name="color">
											</select>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="color_error_message">
											</div>
										</div>
									</div>

									<div class="row">

										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form form-sm mb-0">

												<input type="text" id="price" class="form-control "
													name="price"> <label for="price">Price </label>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="price_error_message">
											</div>
										</div>
									</div>


									<!-- Submit button -->
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
												type="submit" id="submitModel">Submit</button>
										</div>
									</div>

								</form>


								<div id="preparemodelpost"></div>
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
			$
					.ajax({
						type : 'GET',

						url : "http://localhost:8080/" + "getBrands",
						success : function(result) {

							var brandInfo = '<option value="" disabled selected>Brand</option>';
							for (var i = 0; i < result.length; i++) {
								brandInfo += '<option value =' + result[i].name + '>'
										+ result[i].name + '</option>';
							}

							$('#brandDropdown').html(brandInfo);
							//categoryInfo);

						}
					});

			//$('#brandDropdown').change(function(){
			$('#brandDropdown').on('change', function() {
				createModelDropDown();

			});

			function createModelDropDown() {
				var brandName = $("#brandDropdown option:selected").val();

				$
						.ajax({
							type : 'GET',

							url : "http://localhost:8080/"
									+ "getModelsByBrand/" + brandName,
							success : function(result) {

								var modelInfo = '<option value="" disabled selected>Model</option>';
								for (var i = 0; i < result.length; i++) {
									modelInfo += '<option value =' + result[i].name + '>'
											+ result[i].name + '</option>';
								}

								$('#modelDropdown').html(modelInfo);

							}
						});
			}

			$
					.ajax({
						type : 'GET',

						url : "http://localhost:8080/" + "getColors",
						success : function(result) {

							var colorInfo = '<option value="" disabled selected>Color</option>';
							for (var i = 0; i < result.length; i++) {
								colorInfo += '<option value =' + result[i].name + '>'
										+ result[i].name + '</option>';
							}

							$('#colorDropdown').html(colorInfo);
							//categoryInfo);

						}
					});

			$(document)
					.ready(
							function() {
								// SideNav Initialization
								new WOW().init();
								$(".button-collapse").sideNav();
								$('.mdb-select').materialSelect();

								$("#preparemodelform").submit(function(event) {
									event.preventDefault();
									ajaxPost();
								});
								function ajaxPost() {
									var form = $('#preparemodelform')[0];
									var modelData = new FormData(form);

									$
											.ajax({
												type : "POST",
												enctype : 'multipart/form-data',
												url : "http://localhost:8080/"
														+ "assignColorAndPrice",
												data : modelData,
												//dataType: 'json',
												processData : false,
												contentType : false,
												cache : false,
												success : function(result) {
													var post = "<p>"
															+ "Model Post Successfull! <br>"
															+ "Model's Info:<br> Model name = "
															+ result.key.model
															
															+ "<br> Color = "
															+ result.key.color
															+ "<br> Price = "
															+ result.price
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
													$("#preparemodelpost")
															.html(close);

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
													$("#preparemodelpost")
															.html(close);

												}
											});

									// Reset FormData after Posting

								}
							});
		</script>
	</div>
</body>

</html>