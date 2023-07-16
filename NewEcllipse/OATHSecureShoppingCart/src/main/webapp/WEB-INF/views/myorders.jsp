<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>My Orders</title>
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

					<div class="col-md-8 mb-4">
						<!-- Card -->
						<div class="card card-cascade cascading-admin-card user-card">

							<!-- Card Data -->
							<div class="admin-up d-flex justify-content-start">
								<i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
								<div class="data">
									<h5 class="font-weight-bold dark-grey-text">
										My Orders- <span class="text-muted">Your shopping history</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">

								<div class="table-responsive">

									<table class="table product-table table-cart-v-1"
										id="ordertable">

									</table>

								</div>


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

								<p class="mt-4 text-muted">${address}</p>


								<a href="/logout" class="btn btn-info btn-rounded"><i
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
								 var customerId = ${id};
								    
		                            $.ajax({
		                                type: 'GET',
		                                //url: '${pageContext.request.contextPath }/getCustomerOrders/' + customerId,
										url : "http://localhost:8080/"+ "getCustomerOrders/"+customerId,
		                                success: function (orders) {
		    
		                                    var ordertableInfo = '';
		    
		                                    ordertableInfo += '<thead>' +
		                                        '<tr>' +
		                                        '<th scope="col">OrderId</th>' +
		                                        '<th scope="col">Products</th>' +
		                                        '<th scope="col">OrderCost</th>' +
												'<th scope="col">DateOfOrder</th>' +
		                                        '</tr>' +
		                                        '</thead>' +
		                                        '<tbody>';
		                                    for (var i = 0; i < orders.length; i++) {
		                                        ordertableInfo += '<tr>' + '<th scope="row">' + orders[i].id + ' </th>';
		                                        //ordertableInfo += '<td>' +orders[i].productList + '</td>';
		                                        //ordertableInfo += '<td>' +orders[i].ordercost + '</td></tr>';
		                                        ordertableInfo += '<td>';
		                                        for (var h = 0; h < orders[i].productList.length; h++) {
		                                            ordertableInfo += orders[i].productList[h].name + ' : ' + 'Rs.' + orders[i].productList[h].price + '<br> <img src=' + "/uploads/" + orders[i].productList[h].image + ' width="100" height="100" />' + '<br>';
		                                        }
		                                        ordertableInfo += '</td>';
		                                        //ordertableInfo += '<td>' +orders[i].productList + '</td>';
		                                        ordertableInfo += '<td>' + orders[i].ordercost + '</td>';
												 ordertableInfo += '<td>' + orders[i].orderDate + '</td></tr>';
		                                    }
		    
		                                    ordertableInfo += '</tbody>';
		                                    $("#ordertable").html(ordertableInfo);
		                                    $("#ordertable").show();
							}
		                            
		                 });
		          });
		</script>
	</div>
</body>

</html>