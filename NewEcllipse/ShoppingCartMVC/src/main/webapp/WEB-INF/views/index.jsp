<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-datepicker.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="/css/mdb.min.css">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="/css/style.css">
<style>
.intro-2 {
	background:
		/* url("https://mdbootstrap.com/img/Photos/Others/img (51).jpg") */
		url("https://wallpaperaccess.com/full/1496336.jpg") no-repeat center
		center;
	background-size: cover;
}

.view {
	margin-top: -56px;
}

.navbar {
	z-index: 1;
}

html, body, header, .view {
	height: 100%;
}

body {
	background-color: rgb(231, 231, 222);
}

@media only screen and (max-width: 600px) {
	body {
		background-color: lightblue;
	}
}

.datepicker td, .datepicker th {
    width: 2.5rem;
    height: 2.5rem;
    font-size: 0.85rem;
}

.datepicker {
    margin-bottom: 3rem;
}
</style>
</head>

<body>

	<!-- Start your project here-->
	<!--Main Navigation-->
	<header id='home'>


		<nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">

			<a class="navbar-brand" href="#"><strong>Shopping Mart </strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">

					<li class="nav-item "><a class="nav-link" href="#home"
						id="homelink">Home </a></li>

					<li class="nav-item"><a class="nav-link" href="#categorycard"
						id="categorylink">Add Category</a></li>

					<li class="nav-item"><a class="nav-link" href="#productform"
						id="productlink">Add Product</a></li>

					<li class="nav-item"><a class="nav-link" href="#customercard"
						id="customerlink">Add Customer</a></li>

					<li class="nav-item"><a class="nav-link" href="#ordercard"
						id="placeorderlink">Place Order</a></li>

					<li class="nav-item"><a class="nav-link"
						href="#customerhistorycard" id="customerhistorylink">Customer
							History</a></li>

				</ul>
			</div>

		</nav>


		<div class="view intro-2">
			<div class="full-bg-img">
				<div class="mask rgba-black-light flex-center">
					<div class="container text-center white-text">
						<div class="white-text text-center wow fadeInUp">
							<h2>Shopping Mart Application</h2>
							<h5>Have an amazing shopping experience today , explore
								inside</h5>
							<br>
							<p>Pay as you go , we have surprising discounts on each
								product</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</header>

	<!--Main Navigation-->

	<!--Main Layout-->
	<main class="text-center py-5">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- product form start -->
					<div id="productform">
						<div class="card ">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Product</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="productFormId">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip"
															id="productname_error_message"></div>
														<input type="text" id="productname" class="form-control "
															name="name"> <label for="productname">Name</label>
													</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- catageory -->
												<div class="row">
													<div class="col-sm-5"></div>
													<label for="team"></label> <select
														class="browser-default custom-select mb-1 col-sm-5 "
														id="catageoryDropdown" name="catageory">


													</select>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="catageory_error_message">
														</div>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- price -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="price_error_message"></div>
														<input type="text" id="productprice" class="form-control "
															name="price"> <label for="price">Purchase
															Price</label>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- upload image -->

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Upload Product Image</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- upload -->
												<div class="row">
													<div class="col-sm-5"></div>

													<div class="file-field">

														<div class="btn btn-primary btn-sm ">

															<input type="file" id="image" name="imageFile">
														</div>

													</div>

												</div>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="image_error_message"></div>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<button
															class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
															type="submit" id="submitProduct">Submit</button>
													</div>
												</div>
											</td>
										</tr>
									</table>
								</form>
								<!-- Form -->



								<!-- <div class="alert alert-primary alert-dismissible fade show"
									role="alert">
									<strong id="postResultDiv1"> </strong>
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div> -->
								
								<div id="postResultDiv1"> </div>

							</div>

						</div>

					</div>
					<!-- product form end -->

					<!-- category form start -->
					<div id="categorycard">
						<div class="card ">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>category</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									id="categoryform">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip"
															id="categoryname_error_message"></div>
														<input type="text" id="categoryname" class="form-control "
															name="name"> <label for="categoryname">CategoryName</label>
													</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<button
														class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-4"
														type="submit" id="submitCategory">Submit</button>
												</div>
											</td>
										</tr>

									</table>
								</form>
								<!-- Form -->

								
								<div class="alert alert-primary alert-dismissible fade show"
									role="alert" id="postCategory" >
									<strong > </strong>
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								
							</div>

						</div>

					</div>
					<!-- category form end -->

					<!-- customer form start -->
					<div id="customercard">
						<div class="card ">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Customer</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="customerform">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip"
															id="customername_error_message"></div>
														<input type="text" id="customername" class="form-control "
															name="name"> <label for="customername">Customer
															Name</label>
													</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- gender -->

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Gender</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">

														<input type="radio" class="form-check-input gender"
															name="gender" value="male"> <label
															class="form-check-label" for="gender">Male</label>
													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input gender"
															name="gender" value="female"> <label
															class="form-check-label" for="gender">Female</label>
													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input gender"
															name="gender" value="Not Specified"> <label
															class="form-check-label" for="gender">Prefer Not
															to Say</label> <br>

													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="gender_error_message">
														</div>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- price -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-outline">

														<textarea class="form-control" id="address" name="address"
															rows="4"></textarea>
														<label class="form-label" for="address">Full
															Address</label>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="address_error_message">
														</div>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- hobbies -->

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Hobbies</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">

														<input type="checkbox" class="form-check-input hobbyList"
															name="hobbyList" value="Playing Cricket"> <label
															class="form-check-label" for="hobbyList">Playing
															Cricket</label>
													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="checkbox" class="form-check-input hobbyList"
															name="hobbyList" value="Playing Chess"> <label
															class="form-check-label" for="hobbyList">Playing
															Chess</label>
													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="checkbox" class="form-check-input hobbyList"
															name="hobbyList" value="Book Reading"> <label
															class="form-check-label" for="hobbyList">Book
															Reading</label> <br>

													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="checkbox" class="form-check-input hobbyList"
															name="hobbyList" value="Cooking"> <label
															class="form-check-label" for="hobbyList">Cooking</label>
													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="checkbox" class="form-check-input hobbyList"
															name="hobbyList" value="Watching Films"> <label
															class="form-check-label" for="hobbyList">Watching
															Films</label>
													</div>
												</div>



												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="hobby_error_message"></div>
													</div>
												</div>
											</td>
										</tr>


										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<button
															class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
															type="submit" id="submitCustomer">Submit</button>
													</div>
												</div>
											</td>
										</tr>
									</table>
								</form>
								<!-- Form -->

								
								<div class="alert alert-primary alert-dismissible fade show"
									role="alert">
									<strong id="postCustomer"> </strong>
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								
							</div>

						</div>

					</div>
					<!-- customer form end -->


					<!-- place order start -->
					<div id="ordercard">
						<div class="card ">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Place Order</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									enctype="multipart/form-data" id="orderform">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- customers -->
												<div class="row">
													<div class="col-sm-5"></div>
													<label for="team"></label> <select
														class="browser-default custom-select mb-1 col-sm-5 "
														id="customerDropdown" name="customer">


													</select>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="customer_error_message">
														</div>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- catageory -->
												<div class="row">
													<div class="col-sm-5"></div>
													<label for="team"></label> <select
														class="browser-default custom-select mb-1 col-sm-5 "
														id="catageoryDropdown1" name="catageory">


													</select>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="catageory_error_message1">
														</div>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- class="table table-striped table-hover table-bordered border-primary" -->
												<table
													class="table table-striped table-hover table-bordered border-primary"
													id="producttable">

												</table>
											</td>
										</tr>
										<tr>
											<td>
												  <!-- Date Picker Input -->
												  <div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6"> 
												  <div class="form-group mb-4">
													<div class="datepicker date input-group p-0 shadow-sm">
														<input type="text" name="orderDate" placeholder="Order Date" class="form-control py-4 px-4" id="orderDate">
														<div class="input-group-append"><span class="input-group-text px-4"><i class="fa fa-clock-o"></i></span></div>
													</div>
												</div>
												</div><!-- DEnd ate Picker Input -->
												</div>
												
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="date_error_message">
														</div>
													</div>
												</div>

											</td>
										</tr>
										<tr>
											<td>
												<!-- Add to cart button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<button
															class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
															type="button" id="addToCart">Add To Cart</button>
													</div>
												</div>
											</td>
										</tr>
										
										<tr>
											<td> 
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="cart_error_message">
														</div>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<button
															class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-12"
															type="submit">Place Order</button>
													</div>
												</div>

											</td>

										</tr>
										
										<tr>
											<td> 
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="order_error_message">
														</div>
													</div>
												</div>
											</td>
										</tr>
										
										<tr>
											<td><input type="hidden" value="" name="cartList"
												id="submitOrder"></td>
										</tr>

									</table>
								</form>
								<!-- Form -->

								
								<div class="alert alert-primary alert-dismissible fade show"
									role="alert">
									<strong id="postOrder"> </strong>
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								
							</div>

						</div>

					</div>
					<!-- placeorder card end -->


					<!-- customer history card start -->
					<div id="customerhistorycard">
						<div class="card ">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Customer History</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">
								<table align="center" , width="50%" cellpadding="20%">
									<tr>
										<td>
											<!-- customers -->
											<div class="row">
												<div class="col-sm-5"></div>
												<label for="team"></label> <select
													class="browser-default custom-select mb-1 col-sm-5 "
													id="customerDropdown1" name="customer">
												</select>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<table
												class="table table-striped table-hover table-bordered border-primary"
												id="customerInfotable">

											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table
												class="table table-striped table-hover table-bordered border-primary"
												id="ordertable">

											</table>
										</td>
									</tr>

								</table>

								<!-- Form -->

								<div id="postOrder"></div>
							</div>

						</div>

					</div>
					<!-- customer history card end -->


				</div>
			</div>
		</div>

	</main>
	<!--Main Layout-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.js"></script>
	<!-- MDB core JavaScript -->

	<script type="text/javascript" src="/js/mdb.min.js"></script>
	<script type="text/javascript" src="/js/productjs.js"></script>
	<script type="text/javascript" src="/js/orderjs.js"></script>
	<script type="text/javascript" src="/js/customerhistoryjs.js"></script>
	<script type="text/javascript" src="/js/customerjs.js"></script>
	<script type="text/javascript" src="/js/categoryjs.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.datepicker').datepicker({
           clearBtn: true,
           format: "dd/mm/yyyy"
           });
			$("#productform").hide();
			$("#categorycard").hide();
			$("#customercard").hide();
			$("#ordercard").hide();
			$("#customerhistorycard").hide();
			// home link
			$('#homelink').click(function() {

				$("#productform").hide();
				$("#categorycard").hide();
				$("#customercard").hide();
				$("#ordercard").hide();
				$("#customerhistorycard").hide();
			});

		});
	</script>
</body>

</html>