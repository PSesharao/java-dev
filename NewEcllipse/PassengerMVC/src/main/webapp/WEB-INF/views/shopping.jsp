<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Shop</title>
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
										Show Room- <span class="text-muted">Explore Now</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="modelform">
									<!-- Name -->
									<!-- class="mdb-select md-form" searchable="Search here.." -->
									<!-- class="browser-default custom-select"  -->
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
												id="modelDropdown" name="model" onchange="createTable()">

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
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12" id="buy"
												type="button">Buy</button>
										</div>
									</div>
									
								</form>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div id="cart"></div>
										</div>
									</div>
								<div id="sold"></div>
							</div>
						</div>
					</div>
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
										Models - <span class="text-muted">Your Models</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">

								<div class="table-responsive">

									<table class="table product-table table-cart-v-1"
										id="modeltable">

									</table>

								</div>
								<div class="row">
									<div class="col-lg-4"></div>
									<div class="col-lg-4">
										<button
											class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
											type="button" id="addToCart">Add To Cart</button>
									</div>
								</div>

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

			function createTable() {
				var modelName = $("#modelDropdown option:selected").val();
				$
						.ajax({
							type : 'GET',

							url : "http://localhost:8080/"
									+ "getColorsByModel/" + modelName,
							success : function(result) {
								var tableInfo = '';

								tableInfo += '<thead>' + '<tr>'
										+ '<th scope="col">Model</th>'
										+ '<th scope="col">Color</th>'
										+ '<th scope="col">Price</th>'
										+ '</tr>' + '</thead>' + '<tbody>';

								for (var i = 0; i < result.length; i++) {

									tableInfo += '<tr>' + '<td>'
											+ result[i].key.model + ' </td>';
									tableInfo += '<td>' + result[i].key.color
											+ '</td>';
									tableInfo += '<td>' + result[i].price
											+ '</td>';
									tableInfo += '<td>'
										+ '<div class="switch"> <label> <input type="checkbox" class = "productList" name="productList" value="'+result[i].key.color +'"> Remove<span class="lever"></span>Add</label> </div>'
										+ '</td></tr>';
									
								}
								tableInfo += '</tbody>';
								$("#modeltable").html(tableInfo);

							}
						});
			}

			
			var colors = []
		    var models = []
			$("#addToCart")
					.click(
							function() {
								
							   
								var model = $(
								"#modelDropdown option:selected")
								.val();
								console.log($(".productList:checked").length);

								$
										.each(
												$(".productList:checked"),
												function() {
													var color = $(this).val();
													//console.log(color);
													colors.push(color);
													models.push(model);
												
													
												});
								console.log(models);
								console.log(colors);
								$
								.ajax({
									type : 'GET',

									url : "http://localhost:8080/"
											+ "getModelAndColorList/"
											+ models
											+ "/"
											+ colors,
									success : function(
											result) {
										
										var ordertableInfo = 'The Cart List <br>'
										for (var i = 0; i < result.length; i++) {
											
											
											ordertableInfo += result[i].key.model
											        +'    ' + result[i].key.color
													+ ' : '
													+ 'Rs.'
													+result[i].price +'<br>';
													
										}
									var close = '<div class="alert alert-primary alert-dismissible fade show"'+
									'role="alert">'
											+ '<strong>'
											+ ordertableInfo
											+ '</strong>'
											+ '<button type="button" class="close" data-dismiss="alert"'+
									'aria-label="Close">'
											+ '<span aria-hidden="true">&times;</span>'
											+ '</button> </div>';

									$('#cart')
											.html(
													close); 
										
									}
								}); 
								
								
								
							});
			
			$("#buy")
			.click(
					function() {
						
						var brandName = $("#brandDropdown option:selected").val();
						$
						.ajax({
							type : 'GET',

							url : "http://localhost:8080/"
									+ "sell/"
									+ models
									+ "/"
									+ colors
									+ "/"
									+brandName,
							success : function(
									result) {
								
								var ordertableInfo = 'The Sold List <br>'
								for (var i = 0; i < result.length; i++) {
									
									
									ordertableInfo += result[i].key.model
									        +'    ' + result[i].key.color
											+ ' : '
											+ 'Rs.'
											+result[i].price +'<br>';
											
								}
							var close = '<div class="alert alert-primary alert-dismissible fade show"'+
							'role="alert">'
									+ '<strong>'
									+ ordertableInfo
									+ '</strong>'
									+ '<button type="button" class="close" data-dismiss="alert"'+
							'aria-label="Close">'
									+ '<span aria-hidden="true">&times;</span>'
									+ '</button> </div>';

							$('#sold')
									.html(
											close); 
								
							}
						}); 
						
					});


		
			$(document)
					.ready(
							function() {
								// SideNav Initialization
								new WOW().init();
								$(".button-collapse").sideNav();
								$('.mdb-select').materialSelect();
								

								
							});
		</script>
	</div>
</body>

</html>