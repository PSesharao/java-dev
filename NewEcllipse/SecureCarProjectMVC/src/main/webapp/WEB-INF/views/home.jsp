<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home</title>
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

body, html {
	height: 100%;
}

.view {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body class="fixed-sn white-skin">
	<div class="view jarallax" data-jarallax='{"speed": 0.2}'
		style="background-image: url('https://i.pinimg.com/originals/f8/b7/c9/f8b7c978baf20ee116fb339b370c8574.png'); background-repeat: repeat; background-size: cover; background-position: center center;">
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

    
      <!-- Section: Team v.1 -->
      <section class="section team-section">

        <!-- Grid row -->
        <div class="row text-center">

          <!-- Grid column -->
          <div class="col-md-8 mb-4"> 

          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-4 mb-4">

            <!-- Card -->
            <div class="card profile-card">

              <!-- Avatar -->
              <div class="avatar z-depth-1-half mb-4">
                <img src="/uploads/${image}" class="rounded-circle" alt="First sample avatar image">
              </div>

              <div class="card-body pt-0 mt-0">

                <!-- Name -->
                <h3 class="mb-3 font-weight-bold"><strong>${name}</strong></h3>
                <h6 class="font-weight-bold cyan-text mb-4">${email}</h6>

                <p class="mt-4 text-muted">
                	${address}
                </p>

               <!--  <form action="/login?logout=true" method='POST'>
									<div class="text-center form-sm mt-2">
										<button type="submit" class="btn btn-info">
											Log Out <i class="fas fa-sign-in-alt ml-1"></i>
										</button>
									</div>
				</form> -->
                <a href="/login?logout=true" class="btn btn-info btn-rounded" ><i class="fas fa-sign-in-alt ml-1"></i> Logout </a>
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
			$(document).ready(function() {
				// SideNav Initialization
				$(".button-collapse").sideNav();

			});
		</script>
	</div>
</body>

</html>
