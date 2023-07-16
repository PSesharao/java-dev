<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Shop</title>
<!-- Font Awesome -->
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
		style="background-image: url('https://autopilothq.com/uploads/2017/03/20170329-shopping-1-large.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
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
						<li class="nav-item"><a class="nav-link" href="/category"
							id="playerlink">Add Category</a></li>
						<li class="nav-item"><a class="nav-link" href="/product"
							id="teamlink">Add Product</a></li>
						<li class="nav-item"><a class="nav-link" href="/shop"
							id="showlink">Shop Now</a></li>
						<li class="nav-item"><a class="nav-link" href="/myorders"
							id="showlink">My Orders</a></li>
					</ul>
				</div>
			</nav>
			<!-- Navbar -->

		</header>
		<!-- Main Navigation -->

		<!-- Main layout -->
		<main>


			<!-- Section: Team v.1 -->
			<section class="section team-section">

				<!-- Grid row -->
				<div class="row text-center">

					<!-- Grid column -->
					<div class="col-md-8 mb-4">

						<!-- Card -->
						<div class="card card-cascade cascading-admin-card user-card">

							<!-- Card Data -->
							<div class="admin-up d-flex justify-content-start">
								<i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
								<div class="data">
									<h5 class="font-weight-bold dark-grey-text">
										Shop Now - <span class="text-muted">Choose your
											category</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->

							<!-- Card content -->
							<div class="card-body card-body-cascade">
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="orderform">
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<select class="mdb-select md-form" searchable="Search here.."
												id="catageoryDropdown1" name="catageory">

											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="invalid-tooltip" id="catageory_error_message1">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div class="md-form">
												<input placeholder="Selected date" type="text"
													id="date-picker-example"  name="orderDate" class="form-control datepicker">
												<label for="date-picker-example" class="active">Order
													date</label>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
												type="submit">Place Order</button>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div id="cart"></div>
										</div>
									</div>

								<input type="hidden" value="" name="cartList"
												id="submitOrder">
								<input type="hidden" value="${id}" name="customer"
												id="customer">
												
								<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4">
											<div id="postOrder"></div>
										</div>
									</div>
									
								</form>

							</div>
							<!-- Card content -->

						</div>


					</div>
					<!-- Grid column -->

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

								<p class="mt-4 text-muted">${address}</p>


								<a href="/login?logout=true" class="btn btn-info btn-rounded"><i
									class="fas fa-sign-in-alt ml-1"></i> Logout </a>
							</div>

						</div>
						<!-- Card -->

					</div>
					<!-- Grid column -->

				</div>
				<!-- Grid row -->

			</section>
			<!-- Section: Team v.1 -->

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
										Shop - <span class="text-muted">Choose Products</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">

								<div class="table-responsive">

									<table class="table product-table table-cart-v-1"
										id="producttable">

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
		<script src="../../js/jquery-3.4.1.min.js"></script>
		<!-- Bootstrap tooltips -->
		<script type="text/javascript" src="../../js/popper.min.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script type="text/javascript" src="../../js/bootstrap.js"></script>
		<!-- MDB core JavaScript -->
		<script type="text/javascript" src="../../js/mdb.min.js"></script>
		<!-- Custom scripts -->
		<script>
			$(document)
					.ready(
							function() {
								// SideNav Initialization
								new WOW().init();
								$(".button-collapse").sideNav();
								$('.mdb-select').materialSelect();
								$('.datepicker').pickadate();
								$
										.ajax({
											type : 'GET',
											// url: '${pageContext.request.contextPath }/getCategories',
											url : "http://localhost:8080/"
													+ "getCategories",
											success : function(result) {

												var categoryInfo = '<option value="" disabled selected>Category</option>';
												for (var i = 0; i < result.length; i++) {
													categoryInfo += '<option value =' + result[i].name + '>'
															+ result[i].name
															+ '</option>';
												}
												$('#catageoryDropdown1').html(
														categoryInfo);

											}
										});

								$("#catageoryDropdown1").change(function() {

									generateTable();

								});

								function generateTable() {

									var catagoryName = $(
											"#catageoryDropdown1 option:selected")
											.val();

									$
											.ajax({
												type : 'GET',

												url : "http://localhost:8080/"
														+ "getProducts/"
														+ catagoryName,
												success : function(products) {

													var producttableInfo = '';

													producttableInfo += '<thead>'
															+ '<tr>'
															+ '<th scope="col">Id</th>'
															+ '<th scope="col">Name</th>'
															+ '<th scope="col">Price</th>'
															+ '<th scope="col">Image</th>'
															+ '<th scope="col">Choose</th>'
															+ '</tr>'
															+ '</thead>'
															+ '<tbody>';

													for (var i = 0; i < products.length; i++) {

														producttableInfo += '<tr>'
																+ '<td>'
																+ products[i].id
																+ ' </td>';
														producttableInfo += '<td>'
																+ products[i].name
																+ '</td>';
														producttableInfo += '<td>'
																+ products[i].price
																+ '</td>';
														//producttableInfo += '<td>' + players[i].skill +'</td>';

														producttableInfo += '<td><img src=' + "/uploads/" + products[i].image + ' width="250" height="250" /> </td>';
														//producttableInfo += '<td>' + '<input type ="checkbox" class = "productList" name="productList"  value="' + products[i].id + '" >' + '</td>';
														producttableInfo += '<td>'
																+ '<div class="switch"> <label> <input type="checkbox" class = "productList" name="productList" value="'+products[i].id +'"> Remove<span class="lever"></span>Add</label> </div>'
																+ '</td></tr>';

														//producttableInfo += '<td>' +'<input type ="radio" class = "playerId" name="playerId"  value="'+players[i].id+'" >'+'<button type="submit"  class="btn btn-primary">Update</button>'+'</td>'+'</tr>';                	  
														//playertableInfo += '<td>' +'<button type="submit"  value="'+players[i].id+'" name="playerId"  class="btn btn-primary playerId">Update</button>'+'</td>'+'</tr>'; 
													}
													producttableInfo += '</tbody>';
													$("#producttable").html(
															producttableInfo);
													$("#producttable").show();

												}
											});

								}

								var cartList = [];

								// $("body").delegate("#addToCart", "click", function(){
								$("#addToCart")
										.click(
												function() {

													//var cartCategeory = [];

													$
															.each(
																	$(".productList:checked"),
																	function() {

																		cartList
																				.push($(
																						this)
																						.val());
																	});

													$
															.ajax({
																type : 'GET',

																url : "http://localhost:8080/"
																		+ "getProductList/"
																		+ cartList,
																success : function(
																		result) {
																	var ordertableInfo = 'The Cart List <br>'
																	for (var i = 0; i < result.length; i++) {
																		ordertableInfo += result[i].name
																				+ ' : '
																				+ 'Rs.'
																				+ result[i].price
																				+ '<br> <img src=' + "/uploads/" + result[i].image + ' width="100" height="100" />'
																				+ '<br>';
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

																},
																error : function(
																		e) {
																	alert("Error!")
																	console
																			.log(
																					"ERROR: ",
																					e);
																}
															});

													// console.log(cartList);

												});
								
								$("#orderform").submit(function (event) {
									
		                            event.preventDefault();
									
		                            $('#submitOrder').val(cartList);
		                            
		                            
									
		                            var form = $('#orderform')[0];
		    
		                            var orderData = new FormData(form);
		                            
		    
		                            
		                                                    $.ajax({
		                                                        type: "POST",
		                                                        enctype: 'multipart/form-data',
																url : "http://localhost:8080/"+ "placeOrder" ,
		                                                        data: orderData,
		                                                        processData: false,
		                                                        contentType: false,
		                                                        cache: false,
		                                                        success: function (result) {
		                                         
																	var orderDetails = '';
																	orderDetails+= "<p>";
																	orderDetails+= "Post Successfully! <br>";
																	orderDetails+= "---> Orders's Info: OrderId = ";
																	orderDetails+= result.id+'<br>';
																	orderDetails+= "OrderDate = ";
																	orderDetails+= result.orderDate+'<br>';
																	 orderDetails+= '<br> Products Ordered : <br>';
																	
																	for(var i=0 ;i < result.productList.length;i++)
																	{
																		orderDetails+= result.productList[i].name + '   Rs' + result.productList[i].price+'/-<br>';
																	} 
																	orderDetails+= '</p>';
																	console.log(result.productList);
																	var close = '<div class="alert alert-primary alert-dismissible fade show"'+
																	'role="alert">'
																			+ '<strong>'
																			+ orderDetails
																			+ '</strong>'
																			+ '<button type="button" class="close" data-dismiss="alert"'+
																	'aria-label="Close">'
																			+ '<span aria-hidden="true">&times;</span>'
																			+ '</button> </div>';
																	$("#postOrder").html(close);
		                            								
		                                                        }
		                                                        ,
		                                                        error: function (e) {
		                                                            alert("Error!")
		                                                            console.log("ERROR: ", e);
		                                                        }
		                                                    }); 
		    
		    
		                        });
		    
		    

							});
		</script>
	</div>
</body>

</html>